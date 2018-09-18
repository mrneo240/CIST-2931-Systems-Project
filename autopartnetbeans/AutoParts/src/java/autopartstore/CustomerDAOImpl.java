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
public class CustomerDAOImpl implements CustomerDAO {

    private Connection connection;

    public CustomerDAOImpl(Connection connect) {
        connection = connect;
    }

    private Customer extractCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setcid(rs.getInt("id"));
        customer.setcustName(rs.getString("name"));
        customer.setusername(rs.getString("username"));
        customer.setpassword(rs.getString("password"));
        customer.setaddress(rs.getString("address"));
        customer.setemail(rs.getString("email"));
        customer.setcreditC(rs.getString("creditcard"));
        return customer;
    }

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
    
    public Customer getCustomerError() {
        Customer error = new Customer();
        error.setcustName("ERROR");
        return error;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("INSERT INTO customers (ID, name, username, password, email, address, creditcard) "
                    + "VALUES ('" + customer.getcid() + "','" + customer.getcustName() + "','" + customer.getusername()
                    + "','" + customer.getpassword() + "','" + customer.getemail() + "','" + customer.getaddress()
                    + "','" + customer.getcreditC() + "')\n");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        int numUpdated = 0;
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            numUpdated = stmt.executeUpdate("UPDATE customers SET name = '" + customer.getcustName() + "',"
                    + " username = '" + customer.getusername() + "', password = '" + customer.getpassword()
                    + "', address = '" + customer.getaddress() + "', email = '" + customer.getemail() + "',"
                    + " creditcard = '" + customer.getcreditC() + "'  WHERE id=" + customer.getcid());
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numUpdated > 0;
    }

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
