
package autopartstore;

import java.util.ArrayList;

/**
 *
 * @author Michelle (Boobin) Choi
 * @author Hayden K
 */
public class ShoppingCart {

    private ArrayList<Item> cartItems = new ArrayList();
    /**
     * 
     * @return 
     */
    public ArrayList getCartItems() {
        return cartItems;
    }

    /**
     * 
     * @param cartItems 
     */
    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * 
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
     * 
     * @return 
     */
    public double getOrderTax(){
        return getOrderSubTotal()*0.07;
    }
    
    /**
     * 
     * @return 
     */
    public double getOrderTotal() {
        return getOrderSubTotal()+getOrderTax();
    }

    /**
     * 
     * @return 
     */
    public int getLineItemCount() {
        return cartItems.size();
    }

    /**
     * 
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
     * 
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
     * 
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
     * 
     * @param itemIndex
     * @param quant 
     */
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
