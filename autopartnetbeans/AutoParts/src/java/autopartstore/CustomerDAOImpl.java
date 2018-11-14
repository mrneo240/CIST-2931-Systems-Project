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
import autopartstore.json.addressJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerDAOImpl class implements CustomerDAO
 * @author Hayden Kowalchuk
 */
public class CustomerDAOImpl implements CustomerDAO {

    Connection connection;
    Gson gson;

    /**
     * Constructor with Connection Object Parameter
     * @param connect : connection
     */
    public CustomerDAOImpl(Connection connect) {
        connection = connect;
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    /**
     * extractCustomerFromResultSet
     * this method passes resultSet object and sets all the customer values and returns customer
     * @param rs : ResultSet
     * @return customer
     * @throws SQLException 
     */
    private Customer extractCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setcid(rs.getInt("id"));
        customer.setcustName(rs.getString("name"));
        customer.setusername(rs.getString("username"));
        customer.setpassword(rs.getString("password"));
        addressJSON tmp = gson.fromJson(rs.getString("address"), addressJSON.class);
        customer.setaddress(tmp);
        customer.setemail(rs.getString("email"));
        customer.setcreditC(rs.getString("creditcard"));
        return customer;
    }

    /**
     * {@inheritDoc} getAllCustomers
     * this method connects to the customer database and returns all customers
     * @return 
     */
    @Override
    public Set<Customer> getAllCustomers() {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            Set<Customer> customers = new HashSet();
            while (rs.next()) {
                Customer customer = extractCustomerFromResultSet(rs);
                customers.add(customer);
            }
            rs.close();
            stmt.close();
            return customers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc} getCustomerByID
     * this method passes ID and connects to the database.
     * if the id matches with the id in the database, 
     * returns the extractCustomerFromResultSet method with the result.
     * @param id
     * @return extractCustomerFromResultSet(rs)
     */
    @Override
    public Customer getCustomerByID(int id) {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE id=" + id);
            if (rs.next()) {
                return extractCustomerFromResultSet(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getCustomerError();
    }

    /**
     * getCustomerByUsername Method
     * this method passes username and connects to the database.
     * if the username matches with the username in the database,
     * returns the extractCustomerFromResultSet method with result
     * @param user
     * @return extractCustomerFromResultSet(rs)
     */

    public Customer getCustomerByUsername(String user) {
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM customers WHERE username=?");
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractCustomerFromResultSet(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getCustomerError();
    }

    /**
     * GetCustomerGuest Method
     * this method connects to the database if the user is a guest.
     * and returns extractCustomerFromResultSet method with the result
     * @return extractCustomerFromResultSet(rs)
     */
    public Customer getCustomerGuest() {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE username='guest';");
            if (rs.next()) {
                return extractCustomerFromResultSet(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getCustomerError();
    }
    
    /**
     * Get Method that returns error message with customer name
     * @return error
     */

    public Customer getCustomerError() {
        Customer error = new Customer();
        error.setcustName("ERROR");
        return error;
    }

    /**
     * {@inheritDoc} insertCustomer Method
     * this method passes customer object and connects to the database,
     * and insert all customer values such as id, name, username, password, email, address, and credit card
     * @param customer
     * @return numUpdated > 0
     */
    @Override
    public boolean insertCustomer(Customer customer) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("INSERT INTO customers (ID, name, username, password, email, address, creditcard) "
                    + "VALUES ('" + customer.getcid() + "','" + customer.getcustName() + "','" + customer.getusername()
                    + "','" + customer.getpassword() + "','" + customer.getemail() + "','" + gson.toJson(customer.getaddress())
                    + "','" + customer.getcreditC() + "')\n");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    /**
     * {@inheritDoc} updateCustomer method
     * this method passes customer object and connects to the database
     * and update all customer values such as name, username, password, address, email credit card
     * @param customer
     * @return numUpdated > 0
     */
    @Override
    public boolean updateCustomer(Customer customer) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("UPDATE customers SET name = '" + customer.getcustName() + "',"
                    + " username = '" + customer.getusername() + "', password = '" + customer.getpassword()
                    + "', address = '" + gson.toJson(customer.getaddress()) + "', email = '" + customer.getemail() + "',"
                    + " creditcard = '" + customer.getcreditC() + "'  WHERE id=" + customer.getcid());
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    /**
     * {@inheritDoc} deleteCustomer Method
     * this method passes customer object and connects to the database.
     * the data will be deleted that matches with the customer ID
     * @param customer
     * @return numUpdated > 0
     */
    @Override
    public boolean deleteCustomer(Customer customer) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("DELETE FROM customers WHERE id=" + customer.getcid());
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

}
