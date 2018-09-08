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
public interface CustomerDAO {
    Customer getCustomer();
    Set<Customer> getAllCustomer();
    CreditCard getCustomerByID();
    boolean insertCustomer();
    boolean updateCustomer();
    boolean deleteCustomer();
}
