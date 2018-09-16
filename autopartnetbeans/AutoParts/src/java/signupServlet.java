/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */

import autopartstore.Customer;
import autopartstore.CustomerDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hayden Kowalchuk
 */
public class signupServlet extends HttpServlet {

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
    }

    private Statement querySmt = null;
    private ResultSet result = null;

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
        HttpSession session = request.getSession();
        request.removeAttribute("success");
        boolean success = false;

        if (request.getParameter("action").equals("register")) {

            String name = request.getParameter("name").trim();
            String email = request.getParameter("email").trim();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String passwordConfirm = request.getParameter("confirm").trim();
            String address = request.getParameter("address").trim();
            Customer customer = null;
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));

            // Database operations using JDBC
            try {
                //ensure we have a connection to the DB
                Connection temp = ConnectionManager.init(this.getServletContext());

                // Select user from database to check user login id and password
                querySmt = temp.createStatement();
                result = querySmt.executeQuery("select * from Customers where (Username = '" + username + "' OR EMail = '" + email + "');");
                result.last();
                int count = result.getRow();
                if (!password.equals(passwordConfirm)) {
                    //ERROR!
                    request.setAttribute("success", success);
                    request.setAttribute("lastMessage", "Passwords do not match!");
                    return;
                }
                if (count > 0) {
                    //ERROR!
                    request.setAttribute("success", success);
                    request.setAttribute("lastMessage", "Username OR Email already in use!");
                    return;
                }
                customer = new Customer(0, name, address, email, "", username, password);
                success = customerDAO.insertCustomer(customer);
                request.setAttribute("success", success);
                if (success) {
                    request.setAttribute("lastMessage", "Account succesfully created!");
                } else {
                    request.setAttribute("lastMessage", "Some error occurred somewhere! uh oh!");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            } finally {
                try {
                    result.close();
                    querySmt.close();
                } catch (NullPointerException e) {
                    {
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            response.sendRedirect("newsignup.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Provides Singup services and error checking";
    }// </editor-fold>

}
