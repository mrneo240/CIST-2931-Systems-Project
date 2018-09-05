/******************************************************
     * Boobin Choi
     * LoginServlet
     * Mar 14, 2018
******************************************************/

import Business.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * this servlet validates a patient or a dentist to log in the web site.
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
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
         * initiating patient ID and password, Dentist ID and password
         */
        String pid;
        String ppswd;
        String did;
        String dpswd;
        
        try (PrintWriter out = response.getWriter()) {
            /**
             * read the patientID and password or dentistID and password from the previous page
             */
            pid = request.getParameter("patientID");
            ppswd = request.getParameter("patientPassword");
            
            did = request.getParameter("dentistID");
            dpswd = request.getParameter("dentistPassword");                                  
            
            /**
             * if patient ID is not null, look in the patient's database to check if the password matches.
             * if the password matches with the selected patient's id in the database,
             * then finds the information and an appointment, and create the sessions,
             * and forward to DisplayPatient page.
             * if the password is not match, forward to the login error page.
             */
            if (pid!=null) {
                try {
                    Patient p1 = new Patient();
                    p1.selectPatient(pid);
                    
                    if (ppswd.equals(p1.getPatPassword())) {
                        
                        Appointment a1 = new Appointment();
                        a1.selectPatientAppointment(pid);
                        
                        HttpSession sessionOne;
                        sessionOne = request.getSession();
                        sessionOne.setAttribute("p1", p1);
                        
                        HttpSession sessionTwo;
                        sessionTwo = request.getSession();
                        sessionTwo.setAttribute("a1", a1);
                        
                        System.out.println("Patient added to Session");
                        System.out.println(p1.getAppointment().getApptDateTime());
                        System.out.println(a1.getDentist().getDentFirstName());
                        System.out.println(p1.makeAppointment());
                  
                        RequestDispatcher rd = request.getRequestDispatcher("/DisplayPatient.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("/LoginError.jsp");
                        rd.forward(request, response);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            /**
             * if dentist ID is not null, look in the dentist's database to check if the password matches.
             * if the password matches in the database with the selected dentist's id,
             * then finds the information and the appointments, and create the session,
             * and forward to DisplayDentist page.
             * if the password is not match, forward to the login error page.
             */
            else if (did!=null) {
                try {
                    Dentist d1 = new Dentist();
                    d1.selectDentist(did);
                    
                    if (dpswd.equals(d1.getDentPassword())) {                       
                        
                        HttpSession sessionOne;
                        sessionOne = request.getSession();
                        sessionOne.setAttribute("d1", d1);
                        System.out.println("Dentist added to Session");                       
                  
                        RequestDispatcher rd = request.getRequestDispatcher("/DisplayDentist.jsp");
                        rd.forward(request, response);
                    }
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("/LoginError.jsp");
                        rd.forward(request, response);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            else {
                System.out.println("Please enter the ID");
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
