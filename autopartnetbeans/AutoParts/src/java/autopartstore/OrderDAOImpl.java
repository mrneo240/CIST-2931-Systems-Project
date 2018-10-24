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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hayden Kowalchuk
 */
public class OrderDAOImpl implements OrderDAO {

    private Connection connection;

    public OrderDAOImpl(Connection connect) {
        connection = connect;
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setID(rs.getInt("id"));
        order.setCustomerID(rs.getInt("customerid"));
        order.setOrderJSON(rs.getString("orderjson"));
        order.setStatus(rs.getInt("status"));
        order.setTotal(rs.getDouble("total"));
        order.setDate(rs.getDate("dateplaced"));
        return order;
    }

    @Override
    public Set<Order> getAllOrders() {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
            Set<Order> orders = new HashSet();
            while (rs.next()) {
                Order order = extractOrderFromResultSet(rs);
                orders.add(order);
            }
            rs.close();
            stmt.close();
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Order> getAllOrdersByCustomer(int id) {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE customerid='" + id+"' ORDER BY dateplaced DESC");
            
            Set<Order> orders = new HashSet();
            while (rs.next()) {
                Order order = extractOrderFromResultSet(rs);
                orders.add(order);
            }
            rs.close();
            stmt.close();
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getOrderByID(int id) {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE id=" + id);
            if (rs.next()) {
                return extractOrderFromResultSet(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Order getMostRecentOrder() {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders  ORDER BY id DESC LIMIT 1");
            if (rs.next()) {
                return extractOrderFromResultSet(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertOrder(Order order) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO orders VALUES (NULL, ?, ?, ?, ?, ?)");
            stmt.setString(1, order.getOrderJSON());
            stmt.setInt(2, order.getCustomerID());
            stmt.setDate(3, order.getDate());
            stmt.setInt(4, order.getStatus());
            stmt.setDouble(5, order.getTotal());
            numUpdated = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }
    
    @Override
    public boolean updateOrder(Order order) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE orders SET orderjson=?, customerid=?, dateplaced=?, status=?, total=? WHERE ID=?");
            stmt.setString(1, order.getOrderJSON());
            stmt.setInt(2, order.getCustomerID());
            stmt.setDate(3, order.getDate());
            stmt.setInt(4, order.getStatus());
            stmt.setDouble(5, order.getTotal());
            stmt.setInt(6, order.getID());
            numUpdated = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    @Override
    public boolean deleteOrder(Order order) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("DELETE FROM orders WHERE id=" + order.getID());
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

}
