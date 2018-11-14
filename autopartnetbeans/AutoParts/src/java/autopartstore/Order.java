/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

import java.sql.Date;
import java.util.Base64;

/**
 *
 * @author Hayden Kowalchuk
 */
public class Order {

    /**
     * Get Method that returns ID
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Set Method for ID
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Get Method that returns orderJSON
     * @return the orderJSON
     */
    public String getOrderJSON() {
        return orderJSON;
    }

    /**
     * Set Method for OrderJSON
     * @param orderJSON the orderJSON to set
     */
    public void setOrderJSON(String orderJSON) {
        this.orderJSON = orderJSON;
    }

    /**
     * Get Method that returns customerID
     * @return the custID
     */
    public int getCustomerID() {
        return custID;
    }

    /**
     * Set Method for Customer ID
     * @param custID the custID to set
     */
    public void setCustomerID(int custID) {
        this.custID = custID;
    }

    /**
     * Get Method that returns the date
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set Method for Date
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get Method that returns status
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set Method for status
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Get Method that returns the total
     * @return the total
     */
    public Double getTotal() {
        return Math.round(total * 100) / 100.0;
    }

    /**
     * Set Method for Total
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.total = Math.round(Total * 100) / 100.0d;
    }

    /**
     * Properties
     */
    private int ID;
    private String orderJSON;
    private int custID;
    private Date date;
    private int status;
    private double total;

    public String getEncID() {
        if ((ID != 0)) {
            return Base64.getEncoder().encodeToString(("#"+String.valueOf(ID)).getBytes());
        } else {
            return "";
        }
    }

    /**
     * toString Method that returns ID, Customer ID, Date, Status, and Total
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Order[%d, JSON, %d, %s, %d, %f]", getID(), getCustomerID(), getDate(), getStatus(), getTotal());
    }

    /**
     * Display Method for ID, Customer ID, Date, Status, and Total
     */
    public void display() {
        System.out.println(toString());
    }
}
