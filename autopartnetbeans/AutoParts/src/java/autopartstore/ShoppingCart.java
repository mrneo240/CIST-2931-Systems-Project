
package autopartstore;

import java.util.ArrayList;

/**
 *
 * @author Michelle (Boobin) Choi
 * @author Hayden K
 */
public class ShoppingCart {

    /**
     * Property
     */
    private ArrayList<Item> cartItems = new ArrayList();
    
    /**
     * Get Method that returns cartItems
     * @return 
     */
    public ArrayList getCartItems() {
        return cartItems;
    }

    /**
     * Set Method for cartItems
     * @param cartItems 
     */
    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * Get Method that returns the total of the cartItems
     * @return 
     */
    public double getOrderSubTotal() {
        double total = 0.0;
        for (int c = 0; c < cartItems.size(); c++) {
            Item cartItem = (Item) cartItems.get(c);
            total += cartItem.getTotalPrice();
        }
        return total;
    }
    
    /**
     * Get Method that returns the tax of the total
     * @return 
     */
    public double getOrderTax(){
        return getOrderSubTotal()*0.07;
    }
    
    /**
     * Get Method that returns the total include tax
     * @return 
     */
    public double getOrderTotal() {
        return getOrderSubTotal()+getOrderTax();
    }

    /**
     * Get Method that returns the cartItems size
     * @return 
     */
    public int getLineItemCount() {
        return cartItems.size();
    }

    /**
     * AddCartItem Method
     * this method pass an instance of the Item class and add the item 
     * @param item 
     */
    public void addCartItem(Item item) {
        for(Item temp : cartItems){
            if(temp.getPartCode() == item.getPartCode()){
                temp.setQuantity(temp.getQuantity()+1);
                return;
            }
        }
        cartItems.add(item);
    }

    /**
     * Get Method for CartItem
     * this method pass the itemIndex and return the item
     * @param itemIndex
     * @return 
     */
    public Item getCartItem(int itemIndex) {
        Item item = null;
        if (cartItems.size() > itemIndex) {
            item = (Item) cartItems.get(itemIndex);
        }
        return item;
    }
    
    /**
     * DeleteCartItem Method
     * this method pass an itemIndex and removes it
     * @param itemIndex 
     */
    public void deleteCartItem(int itemIndex) {
        try {
            cartItems.remove(itemIndex);
        } catch (NumberFormatException nfe) {
            System.out.println("Error with deleting item in cart: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    /**
     * updateCartItem Method
     * this method passes itemIndex and quantity and update the cartItems
     * @param itemIndex
     * @param quant 
     */
    public void updateCartItem(int itemIndex, int quant) {
        try {

            if (quant > 0) {
                Item cartItem = (Item) cartItems.get(itemIndex);
                cartItem.setQuantity(quant);
                String encodedString = java.util.Base64.getEncoder().encodeToString("hello".getBytes());
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while updating cart: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

}
