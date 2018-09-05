/******************************************************
     * Boobin Choi
     * UpdatePatientServlet
     * Mar 14, 2018
******************************************************/

import Business.*;
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
 * this servlet changes the patient's information.
 */
@WebServlet(urlPatterns = {"/UpdatePatientServlet"})
public class UpdatePatientServlet extends HttpServlet {

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
         * create a session that gets the patient's object
         */
        HttpSession session = request.getSession();
        Patient p1 = (Patient)session.getAttribute("p1");
        //p1.display();
        
        String patientID;
        String newPassword;
        String patientFirstName;
        String patientLastName;
        String newAddress;
        String newEmail;
        String newInsurance;
        
            
        try (PrintWriter out = response.getWriter()) {           
            /**
             * read the patient's first name, last name, id, password, address, email, and insurance from the previous page
             */
            patientFirstName = p1.getPatFirstName();
            patientLastName = p1.getPatLastName();
            patientID = p1.getPatID();
            newPassword = request.getParameter("patientPassword");
            newAddress = request.getParameter("patientAddress");
            newEmail = request.getParameter("patientEmail");           
            newInsurance = request.getParameter("patientInsurance");
            
            /**
             * find the patient's information to change its information and create a new session.
             * then forward back to the DisplayPatient page.
             */
            try {
                p1.selectPatient(patientID);
                p1.updatePatient(patientID, newPassword, patientFirstName, patientLastName, newAddress, newEmail, newInsurance);
            
                p1.display();
                p1.selectPatient(patientID);
            
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("p1", p1);
            
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayPatient.jsp");
                rd.forward(request, response);
                
            }catch(Exception ex) {
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
