/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore;

/**
 * OrderPicker class extends Customer
 * @author Hayden Kowalchuk
 */
public class OrderPicker extends Customer {
    
    /**
     * Get Method that returns true
     * @return 
     */
    @Override
    public boolean getIsAdmin(){
        return true;
    }
    
}
