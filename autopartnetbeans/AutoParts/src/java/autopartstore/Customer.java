
package autopartstore;
/*
 Advance Projects
Auto Parts Store 
 */
public class Customer {
    
    private int cid;
    private String custName;
    private String address;
    private String email;
    private String creditC;
      
    //Constructors
    public Customer(){
        cid = 0;
        custName = "";
        address = "";
        email = "";
        creditC = "";
    }
    public Customer(int i, String cn, String add, String em, String cc){
        cid = i;
        custName = cn;
        address = add;
        email = em;
        creditC = cc;
    }
    
    //Getter and Setters
    public void setcid(int i){
        cid = i;
    }
    public int getcid(){
        return cid;
    }
    
    public void setcustName(String cn){
        custName = cn;
    }
    public String getcustName(){
        return custName;
    }
    
    public void setaddress(String ad){
        address = ad;
    }
    public String getaddress(){
        return address;
    }
    
    public void setemail(String em){
        email = em;
    }
    public String getemail(){
        return email;
    }
    
    public void setcreditC(String cno){
        creditC = cno;
    }
    public String getcreditC(){
        return creditC;
    }
    
    //Display Methods
    public void display(){
        System.out.println("Customer ID "+ getcid());
        System.out.println("Customer Name "+ getcustName());
        System.out.println("Customer Address "+ getaddress());
        System.out.println("Customer email "+ getemail());
        System.out.println("Customer Credit Card # "+ getcreditC());
    }
    
    
//MAin tester
public static void main(String[] args){
        Customer c1;
        c1 = new Customer(546, "kevin Davis", "465 east ake st", "hetdg@gmail.com", "657653567765");
        c1.display();
    }
}