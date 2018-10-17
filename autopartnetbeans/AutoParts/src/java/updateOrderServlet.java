/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */

import autopartstore.Order;
import autopartstore.OrderDAOImpl;
import autopartstore.db.ConnectionManager;
import autopartstore.json.OrderJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hayden Kowalchuk
 */
public class updateOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ref = "";
        if (request.getHeader("referer") != null) {
            String referrerArr[] = request.getHeader("referer").split("/");
            ref = referrerArr[referrerArr.length - 1];
        }
        response.sendRedirect(ref);
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

        OrderDAOImpl orderDAO = (new OrderDAOImpl((new ConnectionManager(false)).getConnection()));
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("admin")) {

            session.setAttribute("jsScript", "$('a[href=\"#orders\"]').trigger('click');");
            String action = request.getParameter("action");

            if (action != null && action.equals("Delete")) {
                Order order = orderDAO.getOrderByID(Integer.parseInt(request.getParameter("orderID")));
                orderDAO.deleteOrder(order);
                session.setAttribute("displayAlert", true);
                session.setAttribute("alertType", "alert-danger");
                session.setAttribute("alertMessage", "Order Succesfully Deleted!");
            } else {
                Order order = orderDAO.getOrderByID(Integer.parseInt(request.getParameter("orderID")));
                OrderJSON tmp = gson.fromJson(order.getOrderJSON(), OrderJSON.class);
                tmp.synchronize();

                int status = Integer.parseInt(request.getParameter("orderStatus"));
                tmp.setStatus(status);
                tmp.setID(order.getID());

                order.setOrderJSON(gson.toJson(tmp));
                orderDAO.updateOrder(order);
                
                session.setAttribute("displayAlert", true);
                session.setAttribute("alertType", "alert-info");
                session.setAttribute("alertMessage", "Order Succesfully Updated!");
            }
            processRequest(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Handle Updating Orders";
    }// </editor-fold>

}
