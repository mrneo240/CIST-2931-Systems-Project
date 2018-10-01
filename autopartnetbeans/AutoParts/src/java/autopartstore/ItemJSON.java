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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.sql.Connection;

/**
 *
 * @author Hayden Kowalchuk
 */
public class ItemJSON {

    @SerializedName("itemID")
    @Expose
    private String itemID;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    
    //Ignore in GSON
    private transient Item item;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
        item = (new ItemDAOImpl(ConnectionManager.getConnection()).getItemByPartCode(itemID));
    }

    public Integer getQty() {
        return item.getQuantity();
    }

    public void setQty(Integer qty) {
    }
    
}
