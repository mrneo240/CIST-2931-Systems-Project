/******************************************************
     * Boobin Choi
     * AppointmentList Class
     * Mar 14, 2018
******************************************************/
package Business;
import java.util.ArrayList;


public class AppointmentList {
    /**
     * Properties
     */
    private ArrayList<Appointment> apptList = new ArrayList<>();
    private int apptListCount;
    
    /**
     * Constructor that takes no argument
     */
    public AppointmentList() {
    }
    
    /**
     * AddAppointment Method
     * this method pass an instance of the appointment class and adds the appointment to the array list object
     * @param appointment : an instance of the appointment
     */
    public void addAppointment(Appointment appointment){
        apptList.add(appointment);
        apptListCount++;
    }
    
    /**
     * RemoveAppointment method
     * this method pass an instance of the appointment class and removes the appointment to the array list object
     * @param appointment : an instance of the appointment
     */
    public void removeAppointment(Appointment appointment){
        apptListCount--;
        
        for(int i = 0; i < apptList.size(); i++){
            if(appointment.equals(apptList.get(i))){
                apptList.remove(i);
            }
        }
    }
    
    /**
     * Get Method for the number of Appointment
     * @return the number of appointments
     */
    public int getCount(){
        return apptListCount;
    }
    
    /**
     * Method that returns to the ArrayList with its appointments
     * @return List of the AppointmentList Array
     */
    public ArrayList<Appointment> getAppointmentList(){
        return apptList;
    }
    
    /**
     * Display Method
     */
    public void display(){
        for(int i = 0; i < apptList.size(); i++){
            System.out.println(apptList.get(i).getApptDateTime()+" "+apptList.get(i).getPatID()+" "+
                    apptList.get(i).getDentID()+" "+apptList.get(i).getProcCode());
            
        }
    }
    
    /**
     * Main Method to test AppointmentList Class
     * @param args 
     */
    public static void main(String args[]) {
        AppointmentList appointmentList = new AppointmentList();
        appointmentList.addAppointment(new Appointment("Nov 1, 2018, 10am", "P1234", "D300","P114"));
        appointmentList.display();
    }
}
