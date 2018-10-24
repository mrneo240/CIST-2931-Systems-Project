package autopartstore;

import autopartstore.json.addressJSON;

/*
 Advance Projects
Auto Parts Store 
 */
public class Customer implements java.io.Serializable {

    private int cid;
    private String custName;
    private addressJSON address;
    private String email;
    private String creditC;
    private String username;
    private String password;

    //Constructors
    public Customer() {
        cid = 0;
        custName = "";
        address = new addressJSON();
        email = "";
        creditC = "";
        password = "";
        username = "";
    }

    public Customer(int i, String cn, addressJSON addr, String em, String cc, String user, String pass) {
        cid = i;
        custName = cn;
        address = addr;
        email = em;
        creditC = cc;
        password = pass;
        username = user;
    }

    //Getter and Setters
    public void setcid(int i) {
        cid = i;
    }

    public int getcid() {
        return cid;
    }

    public void setcustName(String cn) {
        custName = cn;
    }

    public String getcustName() {
        return custName;
    }

    public void setaddress(addressJSON ad) {
        address = ad;
    }

    public addressJSON getaddress() {
        return address;
    }

    public void setemail(String em) {
        email = em;
    }

    public String getemail() {
        return email;
    }

    public void setcreditC(String cno) {
        creditC = cno;
    }

    public String getcreditC() {
        return creditC;
    }

    //Display Methods
    public void display() {
        System.out.println("Customer ID " + getcid());
        System.out.println("Customer Name " + getcustName());
        System.out.println("Customer Address " + getaddress().toString());
        System.out.println("Customer email " + getemail());
        System.out.println("Customer Credit Card # " + getcreditC());
        System.out.println("username " + getpassword());
        System.out.println("Password " + getpassword());
    }

    public boolean getIsAdmin() {
        return false;
    }

    public void setpassword(String pass) {
        password = pass;
    }

    public String getpassword() {
        return password;
    }

    public void setusername(String user) {
        username = user;
    }

    public String getusername() {
        return username;
    }
}
