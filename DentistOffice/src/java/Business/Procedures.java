/******************************************************
     * Boobin Choi
     * Procedures Class
     * Mar 14, 2018
******************************************************/
package Business;
import java.sql.*;


public class Procedures {
    /**
     * Properties
     */
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    
    /**
     * Constructor that takes no argument
     */
    public Procedures() {
        procCode = "";
        procName = "";
        procDesc = "";
        cost = 0.0;
    }
    
    /**
     * Constructor that takes arguments
     * @param c : procedure code
     * @param n : procedure name
     * @param d : procedure description
     * @param cos : procedure cost
     */
    public Procedures(String c, String n, String d, double cos) {
        procCode = c;
        procName = n;
        procDesc = d;
        cost = cos;
    }
    
    /**
     * selectDB Method
     * this method finds the procedure name, description, and cost that belongs to the procedure code in the procedure database
     * @param c : procedure code
     */
    public void selectDB(String c) {
        procCode = c;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c1;
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = c1.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM procedures WHERE procCode = '" +c+ "';");
            resultSet.next();
            procCode = resultSet.getString(1);
            procName = resultSet.getString(2);
            procDesc = resultSet.getString(3);
            cost = resultSet.getDouble(4);
            
            c1.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Get Method for procedure code
     * @return procedure code
     */
    public String getProcCode() { return procCode; }
    /**
     * Set Method for procedure code
     * @param c : procedure code
     */
    public void setProcCode(String c) { procCode=c; }
    
    /**
     * Get Method for procedure name
     * @return procedure name
     */
    public String getProcName() { return procName; }
    /**
     * Set Method for procedure name
     * @param n : procedure name
     */
    public void setProcName(String n) { procName=n; }
    
    /**
     * Get Method for procedure description
     * @return procedure description
     */
    public String getProcDesc() { return procDesc; }
    /**
     * Set Method for procedure description
     * @param d : procedure description
     */
    public void setProcDesc(String d) { procDesc=d; }
    
    /**
     * Get Method for procedure cost
     * @return procedure cost
     */
    public double getCost() { return cost; }
    /**
     * Set Method for procedure cost
     * @param cos : procedure cost
     */
    public void setCost(double cos) { cost=cos; }
    
    /**
     * Display Method for the procedure's code, name, description, and cost
     */
    public void display() {
        System.out.println("Procedure Code = " +procCode);
        System.out.println("Procedure Name = " +procName);
        System.out.println("Procedure Description = " +procDesc);
        System.out.println("Procedure Cost = " +cost);
    }
    
    /**
     * Main Method to test Procedure class objects
     * @param args 
     */
    public static void main(String args[]) {
        Procedures pr1;
        pr1 = new Procedures();
        pr1.selectDB("P114");
        pr1.display();
    }
}
