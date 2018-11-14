/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

import autopartstore.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * ItemDAOImpl class implements ItemDAO
 * @author Hayden Kowalchuk
 * @Edited Levi Llewellyn
 */
public class ItemDAOImpl implements ItemDAO {

    /**
     * properties
     */
    private Connection connection;

    String partTables[] = {"Engine", "Exterior", "Interior", "Maintenance"};

    /**
     * Constructor with connection argument
     * @param connect 
     */
    public ItemDAOImpl(Connection connect) {
        connection = connect;
    }

    /**
     * extractItemFromResultSet Method
     * this method passes the ResultSet object and sets all Item properties
     * @param rs : ResultSet
     * @return item
     * @throws SQLException 
     */
    private Item extractItemFromResultSet(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setID(rs.getInt("id"));
        item.setPartCode(rs.getString("partcode"));
        item.setName(rs.getString("partname"));
        item.setDept(rs.getString("dept"));
        item.setDesc(rs.getString("description"));
        item.setPrice(rs.getDouble("price"));
        String dftphoto = rs.getString("photo");
        if (dftphoto == null) {
            dftphoto = "https://img.clipartxtras.com/f668a365fed3b2830ea7e1aa6b0b0841_oops-sorry-clipart-clipartxtras-oops-clipart-funny_476-480.jpeg";
        } else if (dftphoto.length() == 0 || dftphoto.equals("")) {
            dftphoto = "https://img.clipartxtras.com/f668a365fed3b2830ea7e1aa6b0b0841_oops-sorry-clipart-clipartxtras-oops-clipart-funny_476-480.jpeg";
        }
        item.setphoto(dftphoto);

        return item;
    }

    /**
     * {@inheritDoc } getAllItems Method
     * this method connects to the database and gets all items
     * @return items
     */
    @Override
    public SortedSet<Item> getAllItems() {
        connection = ConnectionManager.getConnection();
        SortedSet<Item> items = new TreeSet<>(Comparator.comparing(Item::getName));
        try {
            for (String table : partTables) {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

                while (rs.next()) {
                    Item item = extractItemFromResultSet(rs);
                    items.add(item);
                }
                rs.close();
                stmt.close();
            }

            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc } getItemByID Method
     * this method passes id and connects to the database to get items by ID
     * @param id
     * @return null
     */
    @Override
    public Item getItemByID(int id) {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, dept, partName, description, price FROM Exterior WHERE ID=" + id
                    + " UNION ALL "
                    + "SELECT ID, dept, partName, description, price FROM Engine WHERE ID=" + id
                    + " UNION ALL "
                    + "SELECT ID, dept, partName, description, price FROM Interior WHERE ID=" + id
                    + " UNION ALL "
                    + "SELECT ID, dept, partName, description, price FROM Maintenance WHERE ID=" + id);
            if (rs.next()) {
                return extractItemFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc} getItemsBySearchParam Method
     * this method passes search and connects to the database to find the items
     * @param search
     * @return items
     */
    @Override
    public Set<Item> getItemsBySearchParam(String search) {
        connection = ConnectionManager.getConnection();
        Set<Item> items = new HashSet();
        try {
            for (String table : partTables) {
                String searchTerms[] = search.split(" ");
                for (String term : searchTerms) {
                    Statement stmt = connection.createStatement();
                    String state = "SELECT * FROM " + table + " WHERE (UPPER(partName) LIKE UPPER('%" + term + "%') "
                            + "OR UPPER(description) LIKE UPPER('%" + term + "%'))";
                    ResultSet rs = stmt.executeQuery(state);
                    while (rs.next()) {
                        Item item = extractItemFromResultSet(rs);
                        items.add(item);
                    }
                    rs.close();
                    stmt.close();
                }
            }

            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc} insertItem Method
     * this method passes Item object and connects to the database and inserts the items
     * @param item
     * @return numUpdated > 0
     */
    @Override
    public SortedSet<Item> getItemsByFeatured() {
        connection = ConnectionManager.getConnection();
        SortedSet<Item> items = new TreeSet<>(Comparator.comparing(Item::getName));
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("(SELECT ID, partCode, dept, partName, description, price, photo FROM Exterior ORDER BY RND(10) LIMIT 1)"
                    + " UNION ALL "
                    + "(SELECT ID, partCode, dept, partName, description, price, photo FROM Engine ORDER BY RND(10) LIMIT 1)"
                    + " UNION ALL "
                    + "(SELECT ID, partCode, dept, partName, description, price, photo FROM Interior ORDER BY RND(10) LIMIT 1)"
                    + " UNION ALL "
                    + "(SELECT ID, partCode, dept, partName, description, price, photo FROM Maintenance ORDER BY RND(10) LIMIT 1) LIMIT 3");
            while (rs.next()) {
                Item item = extractItemFromResultSet(rs);
                items.add(item);
            }
            rs.close();
            stmt.close();
            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertItem(Item item) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO items VALUES (NULL, ?, ?, ?, ?, ?)");
            stmt.setString(1, item.getPartCode());
            stmt.setString(2, item.getDept());
            stmt.setString(3, item.getName());
            stmt.setString(4, item.getDesc());
            stmt.setDouble(5, item.getPrice());
            numUpdated = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    /**
     * {@inheritDoc} updateItem Method
     * this method passes Item object and connects to the database to update items
     * @param item
     * @return numUpdated > 0
     */
    @Override
    public boolean updateItem(Item item) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE ? SET id= ?, dept=?, name=?, desc=?, price=? WHERE partcode=?");
            stmt.setString(1, item.getDept());
            stmt.setInt(2, item.getID());
            stmt.setString(3, item.getDept());
            stmt.setString(4, item.getName());
            stmt.setString(5, item.getDesc());
            stmt.setDouble(6, item.getPrice());
            stmt.setString(7, item.getPartCode());
            numUpdated = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    /**
     * {@inheritDoc} deleteItem Method
     * this method passes Item object and connects to the database to delete the item
     * @param item
     * @return numUpdated > 0
     */
    @Override
    public boolean deleteItem(Item item) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("DELETE FROM " + item.getDept() + " WHERE partcode=" + item.getPartCode());
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    /**
     * {@inheritDoc} getAllItemsByDept Method
     * this method passes department and connects to the database to get the items
     * @param Dept
     * @return items
     */
    @Override
    public Set<Item> getAllItemsByDept(String Dept) {
        connection = ConnectionManager.getConnection();
        Set<Item> items = new HashSet();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + Dept);
            while (rs.next()) {
                Item item = extractItemFromResultSet(rs);
                items.add(item);
            }
            rs.close();
            stmt.close();

            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc} getItemByPartCode Method
     * this method passes code and connects to the database to get the items
     * @param code
     * @return null
     */
    @Override
    public Item getItemByPartCode(String code) {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, partCode, dept, partName, description, price, photo FROM Exterior WHERE PartCode='" + code + "'"
                    + " UNION ALL "
                    + "SELECT ID, partCode, dept, partName, description, price, photo FROM Engine WHERE PartCode='" + code + "'"
                    + " UNION ALL "
                    + "SELECT ID, partCode, dept, partName, description, price, photo FROM Interior WHERE PartCode='" + code + "'"
                    + " UNION ALL "
                    + "SELECT ID, partCode, dept, partName, description, price, photo FROM Maintenance WHERE PartCode='" + code + "'");
            if (rs.next()) {
                return extractItemFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
