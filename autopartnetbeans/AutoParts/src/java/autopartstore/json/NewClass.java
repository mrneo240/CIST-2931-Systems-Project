/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore.json;

import autopartstore.ItemDAOImpl;
import autopartstore.Order;
import autopartstore.OrderDAOImpl;
import autopartstore.db.ConnectionManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Hayden Kowalchuk
 */
public class NewClass {

    public static void main(String[] args) {
        
        
        ItemDAOImpl itemDAO = (new ItemDAOImpl((new ConnectionManager(false)).getConnection()));
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        
        /*OrderJSON order = new OrderJSON();
        order.setCustomerID(12);
        order.setDate(new java.sql.Date(System.currentTimeMillis()));
        order.setID(1);
        order.setStatus(1);
        order.setTotal(69.0);
        
        String jsonString = "[{\"itemID\":\"I2\",\"qty\":1},{\"itemID\":\"M1\",\"qty\":4}]";
        ItemJSON[] tmp = gson.fromJson(jsonString, ItemJSON[].class);
        
        order.setItems(tmp);
        order.synchronize();
        
        String json = gson.toJson(order);*/
        String input = "{\"ID\":1,\"custID\":6,\"total\":69.0,\"items\":[{\"itemID\":\"I2\",\"qty\":1},{\"itemID\":\"M1\",\"qty\":4}],\"lineCount\":2,\"date\":\"Oct 1, 2018\",\"status\":1,\"details\":{\"name\":\"Danielle Strom\",\"addr\":\"987 Thotville lane\"}}";
        OrderJSON tmp = gson.fromJson(input, OrderJSON.class);
        tmp.synchronize();
        System.out.println(tmp.getItems().get(0).getItem().toString());
        
        OrderDAOImpl orderDAO =(new OrderDAOImpl((new ConnectionManager(false)).getConnection()));
        Order order = orderDAO.getOrderByID(1);
        order.setOrderJSON(input);
        orderDAO.insertOrder(order);
        
        System.out.println(gson.toJson(tmp));
        /*
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
        }*/
    }
}
