
package autopartstore;
/*
 Advance Projects
Auto Parts Store 
Customer class implements java.io.Serializable
 */
public class Customer implements java.io.Serializable {
    
    /**
     * Properties
     */
    private int cid;
    private String custName;
    private String address;
    private String email;
    private String creditC;
    private String username;
    private String password;
      
    /**
     * Constructor that takes no argument
     */
    public Customer(){
        cid = 0;
        custName = "";
        address = "";
        email = "";
        creditC = "";
        password = "";
        username = "";
    }
    /**
     * Constructor with parameters
     * @param i : customer ID
     * @param cn : customer Name
     * @param add : customer Address
     * @param em : customer Email
     * @param cc : customer CreditCard Number
     * @param user : customer Password
     * @param pass : customer Username
     */
    public Customer(int i, String cn, String add, String em, String cc, String user, String pass){
        cid = i;
        custName = cn;
        address = add;
        email = em;
        creditC = cc;
        password = pass;
        username = user;
    }
    
    /**
     * Set Method for cid
     * @param i : customer ID
     */
    public void setcid(int i){
        cid = i;
    }
    /**
     * Get Method that returns cid
     * @return cid : customer ID
     */
    public int getcid(){
        return cid;
    }
    /**
     * Set Method for custName
     * @param cn : customer Name
     */
    public void setcustName(String cn){
        custName = cn;
    }
    /**
     * Get Method that returns custName
     * @return custName: customer name
     */
    public String getcustName(){
        return custName;
    }
    /**
     * Set Method for address
     * @param ad : customer address
     */
    public void setaddress(String ad){
        address = ad;
    }
    /**
     * Get Method that returns address
     * @return address : customer address
     */
    public String getaddress(){
        return address;
    }
    /**
     * Set Method for email
     * @param em : customer email
     */
    public void setemail(String em){
        email = em;
    }
    /**
     * Get Method that returns email
     * @return email : customer Email
     */
    public String getemail(){
        return email;
    }
    /**
     * Set Method for CreditCart
     * @param cno : credit card
     */
    public void setcreditC(String cno){
        creditC = cno;
    }
    /**
     * Get Method for credit card
     * @return creditC : credit card
     */
    public String getcreditC(){
        return creditC;
    }
    
    /**
     * Display Method
     */
    public void display(){
        System.out.println("Customer ID "+ getcid());
        System.out.println("Customer Name "+ getcustName());
        System.out.println("Customer Address "+ getaddress());
        System.out.println("Customer email "+ getemail());
        System.out.println("Customer Credit Card # "+ getcreditC());
        System.out.println("username "+ getpassword());
        System.out.println("Password "+ getpassword());
    }
    
    /**
     * Get method that returns false for admin
     * @return false
     */
    public boolean getIsAdmin(){
        return false;
    }
    /**
     * Set Method for password
     * @param pass : password
     */
    public void setpassword(String pass){
        password = pass;
    }
    /**
     * Get Method for password
     * @return password
     */
    public String getpassword(){
        return password;
    }
    /**
     * Set Method for username
     * @param user : username
     */
    public void setusername(String user){
        username = user;
    }
    /**
     * Get Method that returns username
     * @return username
     */
    public String getusername(){
        return username;
    }
    
    
//MAin tester
    /**
     * main Method
     * @param args 
     */
    public static void main(String[] args){
        Customer c1;
        c1 = new Customer(546, "kevin Davis", "465 east ake st", "hetdg@gmail.com", "657653567765", "kdavis1", "123abc");
        c1.display();
    }
}