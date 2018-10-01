/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */

import autopartstore.ItemDAOImpl;
import autopartstore.Order;
import autopartstore.OrderDAOImpl;
import autopartstore.json.ItemJSON;
import autopartstore.ShoppingCart;
import autopartstore.db.ConnectionManager;
import autopartstore.json.OrderJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hayden Kowalchuk
 */
public class orderCheckoutServlet extends HttpServlet {

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

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart != null) {
            String json = gson.toJson(shoppingCart.getCartItems());
            ItemJSON[] tmp = gson.fromJson(json, ItemJSON[].class);

            //Create JSON object
            OrderJSON order = new OrderJSON();
            int custID = (session.getAttribute("loginID") != null ? (int) session.getAttribute("loginID") : -1);
            order.setCustomerID(custID);
            order.setDate(new java.sql.Date(System.currentTimeMillis()));
            order.setStatus(0);
            order.setTotal(shoppingCart.getOrderTotal());
            order.setItems(tmp);

            order.synchronize();

            String orderJSON = gson.toJson(order);

            //Now to create ACTUAL ORDER object
            Order orderObject = new Order();
            orderObject.setCustomerID(custID);
            orderObject.setDate(new java.sql.Date(System.currentTimeMillis()));
            orderObject.setStatus(0);
            orderObject.setTotal(shoppingCart.getOrderTotal());
            orderObject.setOrderJSON(orderJSON);

            OrderDAOImpl orderDAO = (new OrderDAOImpl((new ConnectionManager(false)).getConnection()));

            orderDAO.insertOrder(orderObject);
            
            session.setAttribute("cart", null);
        }

        request.getRequestDispatcher("WEB-INF/orderConfirm.jsp").forward(request, response);
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
