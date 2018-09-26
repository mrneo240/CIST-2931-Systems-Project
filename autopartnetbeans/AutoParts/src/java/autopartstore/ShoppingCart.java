/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore;

import java.util.ArrayList;

/**
 *
 * @author Michelle (Boobin) Choi
 */
public class ShoppingCart {
    
    private ArrayList cartItems = new ArrayList();
    
    public ArrayList getCartItems() {
        return cartItems;
    }
    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }
    
    public double getOrderTotal() {
        double total = 0;
        for (int c = 0; c < cartItems.size(); c++) {
            Item cartItem = (Item) cartItems.get(c);
            total += cartItem.getTotalPrice();
        }
        return total;
    }
    
    public int getLineItemCount() {
        return cartItems.size();
    }
    
    public void addCartItem(Item item) {
        cartItems.add(item);
    }
    
    public Item getCartItem(int itemIndex) {
        Item item = null;
        if(cartItems.size() > itemIndex) {
            item = (Item) cartItems.get(itemIndex);
        }
        return item;
    }
    
    /*public void addCartItem(int id, String dept, String name, String desc, double price, int quant) {
        double totalCost = 0.0;
        double unitPrice = 0.0;
        int quantity = 0;
        
        Item cartItem = new Item();
        
        try {
            unitPrice = price;
            quantity = quant;
            if (quantity > 0) {
                totalCost = unitPrice * quantity;
                cartItem.setID(id);
                cartItem.setDept(dept);
                cartItem.setName(name);
                cartItem.setDesc(desc);
                cartItem.setPrice(price);
                cartItem.setQuantity(quantity);
                cartItem.setTotalPrice(totalCost);
                cartItems.add(cartItem);
                calculateTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while adding items in cart: " +nfe.getMessage());
            nfe.printStackTrace();
        }
    }*/
    
    public void deleteCartItem(int itemIndex) {
        int item = 0;
        try {
            item = itemIndex;
            cartItems.remove(item - 1);
            //calculateTotal();
            
        } catch (NumberFormatException nfe) {
            System.out.println("Error with deleting item in cart: " +nfe.getMessage());
            nfe.printStackTrace();
        }
    }
    
    public void updateCartItem(int itemIndex, int quant) {
        double unitCost = 0.0;
        double totalPrice = 0.0;
        int quantity = 0;
        int index = 0;
        Item cartItem = null;
        
        try {
            index = itemIndex;
            quantity = quant;
            
            if (quantity > 0) {
                cartItem = (Item)cartItems.get(index);
                unitCost = cartItem.getPrice();
                totalPrice = unitCost * quantity;
                cartItem.setQuantity(quantity);
                //calculateTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while updating cart: " +nfe.getMessage());
            nfe.printStackTrace();
        }
    }
    
}
