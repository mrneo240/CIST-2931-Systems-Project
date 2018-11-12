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
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hayden Kowalchuk
 */
public class OrderLookupServlet extends HttpServlet {

    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAOImpl orderDAO = new OrderDAOImpl(ConnectionManager.init(this.getServletContext()));
        try {
            String orderRequested = request.getParameter("order");
            if(orderRequested== null || orderRequested.length() < 1){
                orderRequested = (String)request.getSession().getAttribute("orderEnc");
            }
            request.getSession().setAttribute("orderEnc", orderRequested.trim());
            String orderTemp = (new String(java.util.Base64.getDecoder().decode(orderRequested.trim().getBytes()))).substring(1).trim();

            int orderID = Integer.parseInt(orderTemp);
            Set<Order> orders = new HashSet();
            orders.add(orderDAO.getOrderByID(orderID));

            Set<OrderJSON> ordersFINAL = new HashSet<>();
            for (Order temp : orders) {
                OrderJSON temp2 = gson.fromJson(temp.getOrderJSON(), OrderJSON.class);
                temp2.setID(temp.getID());
                ordersFINAL.add(temp2);
            }
            ordersFINAL.forEach((temp) -> {
                temp.synchronize();
            });

            request.setAttribute("orders", ordersFINAL);
        } catch (Exception e) {
            request.setAttribute("displayAlert", true);
            request.setAttribute("alertType", "alert-danger");
            request.setAttribute("alertMessage", "Invalid or Malformed ID");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/lookupOrder.jsp").forward(request, response);
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
