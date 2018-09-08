
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
    private String username;
    private String password;
      
    //Constructors
    public Customer(){
        cid = 0;
        custName = "";
        address = "";
        email = "";
        creditC = "";
        password = "";
        username = "";
    }
    public Customer(int i, String cn, String add, String em, String cc, String user, String pass){
        cid = i;
        custName = cn;
        address = add;
        email = em;
        creditC = cc;
        password = pass;
        username = user;
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
        System.out.println("username "+ getpassword());
        System.out.println("Password "+ getpassword());
    }
    
    public void setpassword(String pass){
        password = pass;
    }
    
    public String getpassword(){
        return password;
    }
    
    public void setusername(String user){
        username = user;
    }
    
    public String getusername(){
        return username;
    }
    
    
//MAin tester
public static void main(String[] args){
        Customer c1;
        c1 = new Customer(546, "kevin Davis", "465 east ake st", "hetdg@gmail.com", "657653567765", "kdavis1", "123abc");
        c1.display();
    }
}