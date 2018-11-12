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
 * OrderPicker DAOImpl extends CustomerDAOImpl
 * @author Hayden Kowalchuk
 */
public class OrderPickerDAOImpl extends CustomerDAOImpl {

    /**
     * Constructor that pass connection object
     * @param connect 
     */
    public OrderPickerDAOImpl(Connection connect) {
        super(connect);
    }
    
    /**
     * extractCustomerFromResultSet method
     * this method pass the resultset and get id, name, username, and password
     * and set alll values to OrderPicker object
     * @param rs: ResultSet
     * @return picker
     * @throws SQLException 
     */
    private Customer extractCustomerFromResultSet(ResultSet rs) throws SQLException {
        OrderPicker picker = new OrderPicker();
        picker.setcid(rs.getInt("id"));
        picker.setcustName(rs.getString("name"));
        picker.setusername(rs.getString("username"));
        picker.setpassword(rs.getString("password"));
        return picker;
    }

    /**
     * getAllOrderPickers method
     * this method connects to the database and get all data from orderpickers
     * @return Set<Customer>
     */
    public Set<Customer> getAllOrderPickers() {
        connection = ConnectionManager.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orderpickers");
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
     * getOrderPickerByUsername method
     * this method passe user and connects to the database 
     * and get all data from orderpickers
     * @param user
     * @return Customer
     */
    public Customer getOrderPickerByUsername(String user) {
        connection = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM orderpickers WHERE username=?");
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
        return null;
    }

}
