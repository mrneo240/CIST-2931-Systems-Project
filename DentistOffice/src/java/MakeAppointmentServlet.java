/******************************************************
     * Boobin Choi
     * MakeAppointmentServlet
     * Mar 14, 2018
******************************************************/

import Business.Appointment;
import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * this servlet makes an appointment for the patient.
 */
@WebServlet(urlPatterns = {"/MakeAppointmentServlet"})
public class MakeAppointmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /**
         * create a session that gets the patient's object and the appointment object
         */
        HttpSession session = request.getSession();
        Patient p1 = (Patient)session.getAttribute("p1");
        
        HttpSession sessionTwo = request.getSession();
        Appointment a1 = (Appointment)sessionTwo.getAttribute("a1");
        
        
        try (PrintWriter out = response.getWriter()) {
            /**
             * read the patientID, appointment date and time, dentist, and procedure from the previous page
             */
            String patientID = p1.getPatID();
            String dateTime = request.getParameter("dateTime");
            String chooseDentist = request.getParameter("chooseDentist");
            String chooseProcedure = request.getParameter("chooseProcedure");
            
            /**
             * find the patient's information to make an appointment date and time, dentist, and procedure
             * create a new session for the patient and appointment and forward back to the patient's display page
             */
            try {
                p1.selectPatient(patientID);
                p1.makeAppointment(dateTime, chooseDentist, chooseProcedure);
                p1.selectPatient(patientID);
                a1.selectPatientAppointment(patientID);
                
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("p1", p1);
                HttpSession ses2;
                ses2 = request.getSession();
                ses2.setAttribute("a1", a1);
                
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayPatient.jsp");
                rd.forward(request, response);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
