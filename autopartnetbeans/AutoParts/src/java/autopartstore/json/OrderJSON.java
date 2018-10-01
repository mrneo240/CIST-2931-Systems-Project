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
    public int ID;

    //public Customer customer; 
    @SerializedName("custID")
    @Expose
    public int CustomerID;

    @SerializedName("total")
    @Expose
    public Double Total;

    @SerializedName("items")
    @Expose
    public List<ItemJSON> items;

    @SerializedName("lineCount")
    @Expose
    public int lineCount;

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("details")
    @Expose
    public OrderDetailsJSON orderDetails;

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
        this.lineCount = this.items.size();
    }

    /**
     * @param items the items to set
     */
    public void setItems(ItemJSON[] items) {
        this.items.clear();
        this.items.addAll(Arrays.asList(items));
        this.lineCount = this.items.size();
    }

    public void synchronize() {
        for (ItemJSON item : items) {
            item.synchronize();
        }
        this.lineCount = this.items.size();
        if (CustomerID != -1) {
            Customer tmp = (new CustomerDAOImpl(ConnectionManager.getConnection()).getCustomerByID(CustomerID));
            orderDetails.address = tmp.getaddress();
            orderDetails.creditCard = tmp.getcreditC();
            orderDetails.name = tmp.getcustName();
        }
    }

}
