/******************************************************
     * Boobin Choi
     * Appointment Class
     * Mar 14, 2018
******************************************************/
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Appointment {
    /**
     * Properties
     */
    private String apptDateTime;
    private String patID;
    private String dentID;
    private String procCode;
    
    private boolean noAppt = false;
    private Dentist dentist = new Dentist();
    private Procedures procedure = new Procedures();
    
    /**
     * Constructor that takes no parameter
     */
    public Appointment() {
        apptDateTime = "";
        patID = "";
        dentID = "";
        procCode = "";
    }
    
    /**
     * Constructor with parameters
     * @param a : Appointment Date and Time
     * @param pi : Patient ID
     * @param di : Dentist ID
     * @param code : Procedure Code
     */
    public Appointment(String a, String pi, String di, String code) {
        apptDateTime = a;
        patID = pi;
        dentID = di;
        procCode = code;
    }
    
    /**
     * selectPatientAppointment method
     * this method pass a patientID and finds the appointment that belongs to the patientID
     * it also gets the dentist information that belongs to the dentist ID in Dentists Database
     * it also gets the procedure information that belongs to the procedure code in Procedures Database
     * @param pi : patient ID
     */
    public void selectPatientAppointment(String pi) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c1;
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentistoffice?autoReconnect=true&useSSL=false", "scott", "tiger");
            Statement statement = c1.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM appointments WHERE patId = '" +pi+ "';");
            resultSet.next();
            apptDateTime = resultSet.getString(1);
            patID = resultSet.getString(2);
            dentID = resultSet.getString(3);
            procCode = resultSet.getString(4);
            
            noAppt = false;
            
            ResultSet dentResultSet = statement.executeQuery("SELECT * FROM dentists WHERE id = '" +dentID+ "';");
            dentResultSet.next();
            
            this.dentist = new Dentist(dentResultSet.getString(1), dentResultSet.getString(2), dentResultSet.getString(3),
                                            dentResultSet.getString(4), dentResultSet.getString(5), dentResultSet.getString(6));
            
            ResultSet procResultSet = statement.executeQuery("SELECT * FROM procedures WHERE procCode = '" +procCode+ "';");
            procResultSet.next();
            
            this.procedure = new Procedures(procResultSet.getString(1), procResultSet.getString(2), procResultSet.getString(3), 
                                                procResultSet.getDouble(4));
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }    
    
    /**
     * Get Method for the appointment date and time
     * @return  Appointment Date and Time
     */
    public String getApptDateTime() { return apptDateTime; }
    /**
     * Set Method for the appointment date and time
     * @param a : Appointment Date and Time
     */
    public void setApptDateTime(String a) { apptDateTime=a; }
    
    /**
     * Get Method for the patient ID
     * @return Patient ID
     */
    public String getPatID() { return patID; }
    /**
     * Set Method for the patient ID
     * @param pi : Patient ID
     */
    public void setPatID(String pi) { patID=pi; }
    
    /**
     * Get Method for the Dentist ID
     * @return Dentist ID
     */
    public String getDentID() { return dentID; }
    /**
     * Set Method for the Dentist ID
     * @param di : Dentist ID
     */
    public void setDentID(String di) { dentID=di; }
    
    /**
     * Get Method for the Procedure Code
     * @return Procedure Code
     */
    public String getProcCode() { return procCode; }
    /**
     * Set Method for the Procedure Code
     * @param code : Procedure Code
     */
    public void setProcCode(String code) { procCode=code; }
    
    /**
     * Method that checks if there is an appointment 
     * @return boolean value of an appointment
     */
    public boolean noAppt() {
        return noAppt;
    }
    
    /**
     * Method that gets Dentist Information
     * @return dentist
     */
    public Dentist getDentist() {
        return dentist;
    }
    
    /**
     * Method that gets Procedure Information
     * @return procedure
     */
    public Procedures getProcedure() {
        return procedure;
    }
    
    /**
     * Display Method for Appointment date and time, Patient ID, Dentist ID, and Procedure Code
     */
    public void display() {
        System.out.println("Appointment Date and Time = " +apptDateTime);
        System.out.println("Appointment Patient ID = " +patID);
        System.out.println("Appointment Dentist ID = " +dentID);
        System.out.println("Procedure Cost = " +procCode);
    }
    
    /**
     * Main method to test Appointment Business Objects
     * @param args 
     */
    public static void main(String args[]) {

        Appointment a2;
        a2 = new Appointment();
        a2.selectPatientAppointment("A900");
        a2.display();
        
    }
}
