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
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the orderJSON
     */
    public String getOrderJSON() {
        return orderJSON;
    }

    /**
     * @param orderJSON the orderJSON to set
     */
    public void setOrderJSON(String orderJSON) {
        this.orderJSON = orderJSON;
    }

    /**
     * @return the custID
     */
    public int getCustomerID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustomerID(int custID) {
        this.custID = custID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return Math.round(total * 100) / 100.0;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.total = Math.round(Total * 100) / 100.0d;
    }

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

    public String toString() {
        return String.format("Order[%d, JSON, %d, %s, %d, %f]", getID(), getCustomerID(), getDate(), getStatus(), getTotal());
    }

    public void display() {
        System.out.println(toString());
    }
}
