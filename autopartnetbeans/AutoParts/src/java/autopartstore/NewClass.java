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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Hayden Kowalchuk
 */
public class NewClass {

    public static void main(String[] args) {

        String jsonString = "[{\"itemID\":\"I2\",\"qty\":1},{\"itemID\":\"M1\",\"qty\":4}]";
        
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        
        ArrayList<Item> cartItems = new ArrayList();
        cartItems.add((new ItemDAOImpl((new ConnectionManager(false)).getConnection())).getItemByPartCode("I2"));
        cartItems.add((new ItemDAOImpl(ConnectionManager.getConnection())).getItemByPartCode("M4"));

        String json = gson.toJson(cartItems);
        System.out.println(json);

        ItemJSON[] tmp = gson.fromJson(jsonString, ItemJSON[].class);
        System.out.println(tmp[0].getItem().toString());

        for (ItemJSON temp : tmp) {
            System.out.printf("%s, %d %s\n", temp.itemID, temp.qty, temp.getItem().getName());
        }
    }
}
