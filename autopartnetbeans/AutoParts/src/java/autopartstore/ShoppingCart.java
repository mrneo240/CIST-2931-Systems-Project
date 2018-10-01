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

    private ArrayList<Item> cartItems = new ArrayList();

    public ArrayList getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    public double getOrderSubTotal() {
        double total = 0.0;
        for (int c = 0; c < cartItems.size(); c++) {
            Item cartItem = (Item) cartItems.get(c);
            total += cartItem.getTotalPrice();
        }
        return total;
    }
    
    public double getOrderTax(){
        return getOrderSubTotal()*0.07;
    }
    
    
    public double getOrderTotal() {
        return getOrderSubTotal()+getOrderTax();
    }

    public int getLineItemCount() {
        return cartItems.size();
    }

    public void addCartItem(Item item) {
        for(Item temp : cartItems){
            if(temp.getPartCode() == item.getPartCode()){
                temp.setQuantity(temp.getQuantity()+1);
                return;
            }
        }
        cartItems.add(item);
    }

    public Item getCartItem(int itemIndex) {
        Item item = null;
        if (cartItems.size() > itemIndex) {
            item = (Item) cartItems.get(itemIndex);
        }
        return item;
    }
    
    public void deleteCartItem(int itemIndex) {
        try {
            cartItems.remove(itemIndex);
        } catch (NumberFormatException nfe) {
            System.out.println("Error with deleting item in cart: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void updateCartItem(int itemIndex, int quant) {
        try {

            if (quant > 0) {
                Item cartItem = (Item) cartItems.get(itemIndex);
                cartItem.setQuantity(quant);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while updating cart: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

}
