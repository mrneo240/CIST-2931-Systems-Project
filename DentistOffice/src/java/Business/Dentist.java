/******************************************************
      Boobin Choi
      Dentist Class
      Mar 14, 2018
******************************************************/
package Business;
import java.sql.*;

public class Dentist {
    /**
     * Properties
     */
    private String dentID;
    private String dentPassword;
    private String dentFirstName;
    private String dentLastName;
    private String dentEmail;
    private String dentOffice;
    
    private AppointmentList apptList = new AppointmentList();
    
    /**
     * Constructor that takes no argument
     */
    public Dentist() {
        dentID = "";
        dentPassword = "";
        dentFirstName = "";
        dentLastName = "";
        dentEmail = "";
        dentOffice = "";
    }
    
    /**
     * Constructor with parameters
     * @param i : Dentist ID
     * @param p : Dentist Password
     * @param f : Dentist First Name
     * @param l : Dentist Last Name
     * @param e : Dentist Email Address
     * @param o : Dentist Office Number
     */
    public Dentist(String i, String p, String f, String l, String e, String o) {
        this.dentID = i;
        this.dentPassword = p;
        this.dentFirstName = f;
        this.dentLastName = l;
        this.dentEmail = e;
        this.dentOffice = o;
    }
    
    /**
     * selectDentist Method
     * this method passes a dentist ID and connects to the database to find a dentist Information
     * it also finds the appointments that belongs to the dentist ID and adds to the AppointmentList class
     * @param i : Dentist ID
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDentist(String i) throws SQLException, ClassNotFoundException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dentists where id='" + i + "';");           
            resultSet.next();
            
            dentID = resultSet.getString(1);
            dentPassword = resultSet.getString(2);
            dentFirstName = resultSet.getString(3);
            dentLastName = resultSet.getString(4);
            dentEmail = resultSet.getString(5);
            dentOffice = resultSet.getString(6);
                      
            ResultSet apptListResultSet = statement.executeQuery("SELECT * FROM Appointments where dentId='" + i + "';");
            
            while (apptListResultSet.next()) {                
                Appointment appt1 = new Appointment(apptListResultSet.getString(1), apptListResultSet.getString(2), 
                        apptListResultSet.getString(3),apptListResultSet.getString(4));
                
                //appt1.display();
                
                apptList.addAppointment(appt1);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * updateDentist Method
     * this method updates the dentist's Password, First Name, Last Name, Email Address, and Office number 
     * that belongs to the dentist ID
     * @param i : dentist ID 
     * @param p : dentist Password
     * @param f : dentist First Name
     * @param l : dentist Last Name
     * @param e : dentist Email Address
     * @param o : dentist Office Number
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateDentist(String i, String p, String f, String l, String e, String o)
            throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = connection.createStatement();
            String query = "UPDATE Dentists SET passwd='" +p+ "', firstName='" +f+ "', lastName='" +l+ "', "
                    + "email='" +e+ "', office='" +o+ "' WHERE id='" +i+ "';"; 
            
            statement.executeUpdate(query);
            query = "SELECT * FROM Dentists WHERE id='" +i+ "';";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            
            dentID = resultSet.getString(1);
            dentPassword = resultSet.getString(2);
            dentFirstName = resultSet.getString(3);
            dentLastName = resultSet.getString(4);
            dentEmail = resultSet.getString(5);
            dentOffice = resultSet.getString(6);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    /**
     * Get Method for Dentist ID
     * @return Dentist ID
     */
    public String getDentID() { return dentID; }
    /**
     * Set Method for Dentist ID
     * @param i : Dentist ID
     */
    public void setDentID(String i) { dentID=i; }
    
    /**
     * Get Method for Dentist Password
     * @return Dentist Password
     */
    public String getDentPassword() { return dentPassword; }
    /**
     * Set Method for Dentist Password
     * @param p : Dentist Password
     */
    public void setDentPassword(String p) { dentPassword=p; }
    
    /**
     * Get Method for Dentist First Name
     * @return Dentist First Name
     */
    public String getDentFirstName() { return dentFirstName; }
    /**
     * Set Method for Dentist First Name
     * @param f : Dentist First Name
     */
    public void setDentFirstName(String f) { dentFirstName=f; }
    
    /**
     * Get Method for Dentist Last Name
     * @return Dentist Last Name
     */
    public String getDentLastName() { return dentLastName; }
    /**
     * Set Method for Dentist Last Name
     * @param l : Dentist Last Name
     */
    public void setDentLastName(String l) { dentLastName=l; }
    
    /**
     * Get Method for Dentist Email Address
     * @return Dentist Email
     */
    public String getDentEmail() { return dentEmail; }
    /**
     * Set Method for Dentist Email Address
     * @param e : Dentist Email
     */
    public void setDentEmail(String e) { dentEmail=e; }
    
    /**
     * Get Method for Dentist Office Number
     * @return Dentist Office number
     */
    public String getDentOffice() { return dentOffice; }
    /**
     * Set Method for Dentist Office Number
     * @param o : Dentist Office Number
     */
    public void setDentOffice(String o) { dentOffice=o; }
    
    /**
     * Method that returns the AppointmentList object
     * @return appointment list
     */
    public AppointmentList getAppointmentList() {
        return apptList;
    }
    
    /**
     * Display Method for a dentist's ID, password, first name, last name, email address, and office number
     */
    public void display() {
        System.out.println("Dentist ID = " +dentID);
        System.out.println("Dentist Password = " +dentPassword);
        System.out.println("Dentist FirstName = " +dentFirstName);
        System.out.println("Dentist LastName = " +dentLastName);
        System.out.println("Dentist Email = " +dentEmail);
        System.out.println("Dentist Office = " +dentOffice);
    }
    
    /**
     * Main method to test Dentist Class Object
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Dentist d1;
        d1 = new Dentist();
        d1.selectDentist("D201");
        d1.display();
        
    }
}
