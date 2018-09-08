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
public class address {
    
    
     private String street;
     private String city;
     private String state;
     private String zip;
     
     
     public address(){
         street = "";
         city = "";
         state = "";
         zip = "";       
     }
     
     public address(String st, String ct, String ste, String zp){
         street = st;
         city = ct;
         state = ste;
         zip = zp;
     }
      
     public void setstreet(String st){
         street = st;
     }
    public String getstreet(){
        return street;
    }
    
    public void setcity(String ct){
        city = ct;
    }
    public String getcity(){
        return city;
    }
    
    public void setstate(String ste){
        state = ste;
    }
    public String getstate(){
        return state;
    }
    
    public void setzip(String zp){
        zip = zp;
    }
    public String getzip(){
        return zip;
    }
    
    public void display(){
        System.out.println("Street = "+ getstreet());
        System.out.println("City = "+ getcity());
        System.out.println("State = "+ getstate());
        System.out.println("Zip = "+ getzip());
        
    }
    
    public String toString(){
        return String.format("%s %s, %s %s", getstreet(), getcity(), getstate(), getzip());
    }
    
    public static void main(String[] args){
        address a1 = new address("167 timber st", "atlanta", "ga", "11342");
        a1.display();   
    }
}
