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

/**
 *
 * @author Hayden Kowalchuk
 */
public class ItemJSON {

    @SerializedName("itemID")
    @Expose
    public String itemID = "";

    @SerializedName("qty")
    @Expose
    public int qty = 0;

    @Expose(serialize = false)
    private Item item;

    public void synchronize() {
        if (itemID != null && item == null) {
            System.out.println("Creating new JSON Item with code:" + itemID);
            item = (new ItemDAOImpl(ConnectionManager.getConnection()).getItemByPartCode(itemID));
            System.out.println(item.getPartCode() + " Item Created succesfully!");
        }
    }

    public Item getItem() {
        synchronize();
        return item;
    }

}
