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
 * interface CreditCardDAO
 * @author Hayden Kowalchuk
 */
public interface CreditCardDAO {
    CreditCard getCard();
    Set<CreditCard> getAllCards();
    CreditCard getCardByCustomerID();
    boolean insertCard();
    boolean updateCard();
    boolean deleteCard();
}
