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
public interface ItemDAO {
    Set<Item> getAllItems();
    Set<Item> getAllItemsByDept(String Dept);
    Item getItemByID(int id);
    boolean insertItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(Item item);
}
