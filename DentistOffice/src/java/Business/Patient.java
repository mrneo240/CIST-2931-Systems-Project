/******************************************************
     * Boobin Choi
     * Patient Class
     * Mar 14, 2018
******************************************************/
package Business;
import java.sql.*;

public class Patient {
    /**
     * Properties
     */
    private String patID;
    private String patPassword;
    private String patFirstName;
    private String patLastName;
    private String patAddress;
    private String patEmail;
    private String patInsurance;
    
    private Appointment appointment = new Appointment();
    private boolean apptAvailable = false;
    
    /**
     * Constructor that takes no argument
     */
    public Patient() {
        patID = "";
        patPassword = "";
        patFirstName = "";
        patLastName = "";
        patAddress = "";
        patEmail = "";
        patInsurance = "";
    }
    
    /**
     * Constructor that takes arguments
     * @param id : patient ID
     * @param p : patient password
     * @param f : patient first name
     * @param l : patient last name
     * @param a : patient address
     * @param e : patient email address
     * @param in : patient insurance
     */
    public Patient(String id, String p, String f, String l, String a, String e, String in) {
        patID = id;
        patPassword = p;
        patFirstName = f;
        patLastName = l;
        patAddress = a;
        patEmail = e;
        patInsurance = in;
    }
    
    /**
     * selectPatient Method
     * this method looks up the Patient database and gets the information that belongs to the patient ID
     * it also finds the patient's appointment in Appointments database if it exists
     * @param id : patient ID
     */
    public void selectPatient(String id) {
        patID = id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c1;
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = c1.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patients WHERE patId = '" +id+ "';");
            resultSet.next();
            patID = resultSet.getString(1);
            patPassword = resultSet.getString(2);
            patFirstName = resultSet.getString(3);
            patLastName = resultSet.getString(4);
            patAddress = resultSet.getString(5);
            patEmail = resultSet.getString(6);
            patInsurance = resultSet.getString(7);
            
            ResultSet apptResultSet = statement.executeQuery("SELECT * FROM appointments WHERE patId = '" +id+ "';");
            apptResultSet.next();
            
            this.appointment = new Appointment(apptResultSet.getString(1), apptResultSet.getString(2), apptResultSet.getString(3),
                                            apptResultSet.getString(4));
            this.apptAvailable = true;                       
                                            
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * updatePatient Method
     * this method passes the patient's ID and updates its password, first name, last name, address,
     * email address, and insurance
     * @param id : patient ID
     * @param p : patient Password
     * @param f : patient first name
     * @param l : patient last name
     * @param a : patient address
     * @param e : patient email address
     * @param i : patient insurance
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updatePatient(String id, String p, String f, String l, String a, String e, String i)
            throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = connection.createStatement();
            String query = "UPDATE Patients SET passwd='" +p+"', firstName='" +f+ "', lastName='" +l+ "', "
                    + "addr='" +a+ "', email='" +e+ "', insCo='" +i+ "' WHERE patId='" +id+ "';";                    
            
            statement.executeUpdate(query);
            
            query = "SELECT * FROM Patients WHERE patId='" +id+ "';";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            patID = resultSet.getString(1);
            patPassword = resultSet.getString(2);
            patFirstName = resultSet.getString(3);
            patLastName = resultSet.getString(4);
            patAddress = resultSet.getString(5);
            patEmail = resultSet.getString(6);
            patInsurance = resultSet.getString(7);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * makeAppointment Method
     * this method makes an appointment in the Appointment database
     * @param dateTime
     * @param dentID
     * @param proc
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void makeAppointment(String dateTime, String dentID, String proc)
            throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Appointments (apptDateTime, patId, dentId, procCode) "
                    + "VALUES('" +dateTime+ "', '" +patID+ "', '" +dentID+ "', '" +proc+ "');";                 
            
            statement.executeUpdate(query);
            
            query = "SELECT * FROM Patients WHERE patId='" +patID+ "';";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            patID = resultSet.getString(1);
            patPassword = resultSet.getString(2);
            patFirstName = resultSet.getString(3);
            patLastName = resultSet.getString(4);
            patAddress = resultSet.getString(5);
            patEmail = resultSet.getString(6);
            patInsurance = resultSet.getString(7);
            
            apptAvailable = true;

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * changeAppointment Method
     * this method change the patient's an appointment date and time, dentist, and procedure
     * @param dateTime
     * @param dentId
     * @param proc
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void changeAppointment(String dateTime, String dentId, String proc)
            throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = connection.createStatement();
            String query = "UPDATE Appointments SET apptDateTime='" +dateTime+ "', dentId='" +dentId+"', procCode='" +proc+"' WHERE patId='" +patID+ "';";                
            
            statement.executeUpdate(query);
            
            query = "SELECT * FROM Patients WHERE patId='" +patID+ "';";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            patID = resultSet.getString(1);
            patPassword = resultSet.getString(2);
            patFirstName = resultSet.getString(3);
            patLastName = resultSet.getString(4);
            patAddress = resultSet.getString(5);
            patEmail = resultSet.getString(6);
            patInsurance = resultSet.getString(7);
            
            apptAvailable = true;

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * Get Method for Patient ID
     * @return Patient ID
     */
    public String getPatID() { return patID; }
    /**
     * Set Method for Patient ID
     * @param id : patient ID
     */
    public void setPatID(String id) { patID=id; }
    
    /**
     * Get Method for Patient password
     * @return Patient Password
     */
    public String getPatPassword() { return patPassword; }
    /**
     * Set Method for Patient password
     * @param p : patient password
     */
    public void setPatPassword(String p) { patPassword=p; }
    
    /**
     * Get Method for Patient first name
     * @return Patient First Name
     */
    public String getPatFirstName() { return patFirstName; }
    /**
     * Set Method for patient first name
     * @param f : patient first name
     */
    public void setPatFirstName(String f) { patFirstName=f; }
    
    /**
     * Get Method for Patient Last Name
     * @return Patient Last Name
     */
    public String getPatLastName() { return patLastName; }
    /**
     * Set Method for patient last name
     * @param l : patient last name
     */
    public void setPatLastName(String l) { patLastName=l; }
    
    /**
     * Get Method for patient address
     * @return patient address
     */
    public String getPatAddress() { return patAddress; }
    /**
     * Set Method for patient address
     * @param a : patient address
     */
    public void setPatAddress(String a) { patAddress=a; }
    
    /**
     * Get Method for patient email address
     * @return patient email address
     */
    public String getPatEmail() { return patEmail; }
    /**
     * Set Method for patient email address
     * @param e : patient email address
     */
    public void setPatEmail(String e) { patEmail=e; }
    
    /**
     * Get Method for patient insurance
     * @return patient insurance
     */
    public String getPatInsurance() { return patInsurance; }
    /**
     * Set Method for patient insurance
     * @param i : patient insurance
     */
    public void setPatInsurance(String i) { patInsurance=i; }
    
    /**
     * Method that returns to the appointment class if it exists
     * @return appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }
    /**
     * Method that returns to the appointment availability boolean value
     * @return 
     */
    public boolean makeAppointment() {
        return apptAvailable;
    }
    
    /**
     * Display Method to display patient's ID, password, first name, last name, address, email, and insurance
     */
    public void display() {
        System.out.println("Patient ID = " +patID);
        System.out.println("Patient Password = " +patPassword);
        System.out.println("Patient FirstName = " +patFirstName);
        System.out.println("Patient LastName = " +patLastName);
        System.out.println("Patient Address = " +patAddress);
        System.out.println("Patient Email = " +patEmail);
        System.out.println("Patient Insurance = " +patInsurance);
    }
    
    /**
     * Main Method to test Patient class objects
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void main(String args[])throws SQLException, ClassNotFoundException {
        Patient p1;
        p1 = new Patient();
        p1.selectPatient("A900");
        p1.display();       
        
//        Patient p2;
//        p2 = new Patient("A900", "1111", "Jimmy", "Hawkins", "Acworth", "j@yahoo.com","Happy");
//        p2.updatePatient(p2.getPatID(), p2.getPatPassword(), p2.getPatFirstName(), p2.getPatLastName(),
//                p2.getPatAddress(), p2.getPatEmail(), p2.getPatInsurance());
//        p2.display();
    }
}
