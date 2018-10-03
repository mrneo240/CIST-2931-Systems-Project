/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

import java.util.Set;

/**
 *
 * @author Hayden Kowalchuk
 */
public interface OrderDAO {
    Set<Order> getAllOrders();
    Set<Order> getAllOrdersByCustomer(int id);
    Order getOrderByID(int id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Order order);
}