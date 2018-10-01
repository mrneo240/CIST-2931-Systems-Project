/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore.json;

import autopartstore.Customer;
import autopartstore.CustomerDAOImpl;
import autopartstore.db.ConnectionManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hayden Kowalchuk
 */
public class OrderJSON {

    public OrderJSON() {
        items = new ArrayList<>();
        orderDetails = new OrderDetailsJSON();
    }

    @SerializedName("ID")
    @Expose
    private int ID;

    //public Customer customer; 
    @SerializedName("custID")
    @Expose
    private int CustomerID;

    @SerializedName("total")
    @Expose
    private Double Total;

    @SerializedName("items")
    @Expose
    public List<ItemJSON> items;

    @SerializedName("lineCount")
    @Expose
    private int lineCount;

    @SerializedName("date")
    @Expose
    private Date date;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("details")
    @Expose
    private OrderDetailsJSON orderDetails;

    /**
     * @return the items
     */
    public List<ItemJSON> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ItemJSON> items) {
        this.items.clear();
        this.items = items;
        this.setLineCount(this.items.size());
    }

    /**
     * @param items the items to set
     */
    public void setItems(ItemJSON[] items) {
        this.items.clear();
        this.items.addAll(Arrays.asList(items));
        this.setLineCount(this.items.size());
    }

    public void synchronize() {
        for (ItemJSON item : items) {
            item.synchronize();
        }
        this.setLineCount(this.items.size());
        if (getCustomerID() != -1) {
            Customer tmp = (new CustomerDAOImpl(ConnectionManager.getConnection()).getCustomerByID(getCustomerID()));
            orderDetails.address = tmp.getaddress();
            orderDetails.creditCard = tmp.getcreditC();
            orderDetails.name = tmp.getcustName();
        }
    }

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
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the Total
     */
    public Double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.Total = Total;
    }

    /**
     * @return the lineCount
     */
    public int getLineCount() {
        return lineCount;
    }

    /**
     * @param lineCount the lineCount to set
     */
    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
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
     * @return the orderDetails
     */
    public OrderDetailsJSON getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(OrderDetailsJSON orderDetails) {
        this.orderDetails = orderDetails;
    }

}
