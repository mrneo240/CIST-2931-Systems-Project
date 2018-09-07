/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore;

/*
 Advance Projects
Auto Parts Store 
 */
public class CreditCard {
    
    private String CreditCardN;
    private String CardName;
    private String CardType;
    private String ExDate;
    private String CW;
    
    public CreditCard(){
        CreditCardN = "";
        CardName = "";
        CardType = "";
        ExDate = "";
        CW = "";
    }
    
    public CreditCard(String ccn, String cn, String ct, String ex, String ccw){
        CreditCardN = ccn;
        CardName = cn;
        CardType = ct;
        ExDate = ex;
        CW = ccw;
    }
    
    public void setCardN(String ccn){
        CreditCardN = ccn;
    }
    public String getCardN(){
        return CreditCardN;
    }
    
    public void setCardName(String cn){
        CardName = cn;
    }
    public String getCardName(){
        return CardName;
    }
    
    public void setCardType(String ct){
        CardType = ct;
    }
    public String getCardType(){
        return CardType;
    }
    public void setExDate(String ex){
        ExDate = ex;
    }
    public String getExdate(){
        return ExDate;
    }
    public void setCW(String ccw){
        CW = ccw;
    }
    public String getCW(){
        return CW;
    }
    
    public void display(){
        System.out.println("Card Number = "+getCardN());
        System.out.println("Card Name = "+getCardName());
        System.out.println("CardType = "+getCardType());
        System.out.println("Expiry Date = "+getExdate());
        System.out.println("CW = "+ getCW());
        
    }
    
    public static void main(String[] args){
        CreditCard cc1 = new CreditCard("345365653532", "kevin davis", "Visa", "08-12-09", "756");
        cc1.display();
    }
    
}
