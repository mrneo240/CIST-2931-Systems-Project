/******************************************************
     * Boobin Choi
     * UpdateDentistServlet
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
 * this servlet updates a dentist's information.
 */
@WebServlet(urlPatterns = {"/UpdateDentistServlet"})
public class UpdateDentistServlet extends HttpServlet {

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
         * create a session that gets a dentist object
         */
        HttpSession session = request.getSession();
        Dentist d1 = (Dentist)session.getAttribute("d1");
        //d1.display();
        
        String dentistID;
        String newPassword;
        String dentistFirstName;
        String dentistLastName;
        String newEmail;
        String newOfficeNo;
        
        try (PrintWriter out = response.getWriter()) {
            /**
             * read the dentist's first name, last name, id, password, email, and an office number from the previous page.
             */
            dentistFirstName = d1.getDentFirstName();
            dentistLastName = d1.getDentLastName();
            dentistID = d1.getDentID();
            newPassword = request.getParameter("dentistPassword");
            newEmail = request.getParameter("dentistEmail");           
            newOfficeNo = request.getParameter("dentistOffice");
            
            /**
             * find the dentist information to change its information and create a new session.
             * then forward to DisplayDentist page.
             */
            try {
                d1.selectDentist(dentistID);
                d1.updateDentist(dentistID, newPassword, dentistFirstName, dentistLastName, newEmail, newOfficeNo);
            
                //d1.display();
                d1.selectDentist(dentistID);
            
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("d1", d1);
            
                RequestDispatcher rd = request.getRequestDispatcher("/DisplayDentist.jsp");
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
