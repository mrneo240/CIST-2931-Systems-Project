/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore;

/*
 Advance Projects
Auto Parts Store 
CreditCard Class
 */
public class CreditCard {
    
    /**
     * Properties
     */
    private String CreditCardN;
    private String CardName;
    private String CardType;
    private String ExDate;
    private String CW;
    
    /**
     * Constructor that takes no argument
     */
    public CreditCard(){
        CreditCardN = "";
        CardName = "";
        CardType = "";
        ExDate = "";
        CW = "";
    }
    
    /**
     * Constructor with parameters
     * @param ccn : credit card number
     * @param cn : card name
     * @param ct : card type
     * @param ex : expired date
     * @param ccw : security code
     */
    public CreditCard(String ccn, String cn, String ct, String ex, String ccw){
        CreditCardN = ccn;
        CardName = cn;
        CardType = ct;
        ExDate = ex;
        CW = ccw;
    }
    
    /**
     * Set Method for credit card number
     * @param ccn : credit card number
     */
    public void setCardN(String ccn){
        CreditCardN = ccn;
    }
    
    /**
     * Get Method that returns CreditCardN
     * @return CreditCardN : credit card number
     */
    public String getCardN(){
        return CreditCardN;
    }
    
    /**
     * Set Method for CardName
     * @param cn : card name
     */
    public void setCardName(String cn){
        CardName = cn;
    }
    
    /**
     * Get Method for CardName
     * @return CardName
     */
    public String getCardName(){
        return CardName;
    }
    
    /**
     * Set Method for CardType
     * @param ct : card type
     */
    public void setCardType(String ct){
        CardType = ct;
    }
    
    /**
     * Get Method that returns CardType
     * @return CardType
     */
    public String getCardType(){
        return CardType;
    }
    
    /**
     * Set Method for Expired date
     * @param ex : expired date
     */
    public void setExDate(String ex){
        ExDate = ex;
    }
    
    /**
     * Get Method that returns expired date
     * @return ExDate : expired date
     */
    public String getExdate(){
        return ExDate;
    }
    
    /**
     * Set Method for CW
     * @param ccw : security code
     */
    public void setCW(String ccw){
        CW = ccw;
    }
    
    /**
     * Get Method that returns CW
     * @return CW : security code
     */
    public String getCW(){
        return CW;
    }
    
    /**
     * Display Method
     */
    public void display(){
        System.out.println("Card Number = "+getCardN());
        System.out.println("Card Name = "+getCardName());
        System.out.println("CardType = "+getCardType());
        System.out.println("Expiry Date = "+getExdate());
        System.out.println("CW = "+ getCW());
        
    }
    
    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args){
        CreditCard cc1 = new CreditCard("345365653532", "kevin davis", "Visa", "08-12-09", "756");
        cc1.display();
    }
    
}
