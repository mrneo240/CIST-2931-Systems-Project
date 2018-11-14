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
 * interface CustomerDAO
 * @author Hayden Kowalchuk
 */
public interface CustomerDAO {
    Set<Customer> getAllCustomers();
    Customer getCustomerByID(int id);
    boolean insertCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
}
