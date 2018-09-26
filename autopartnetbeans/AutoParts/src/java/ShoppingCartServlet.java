/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import autopartstore.*;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michelle (Boobin) Choi
 */
@WebServlet(urlPatterns = {"/ShoppingCartServlet"})
public class ShoppingCartServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && !action.equals("")) {
            if (action.equals("add")) {
                addToCart(request);

            } else if (action.equals("Update")) {

                updateCart(request);

            } else if (action.equals("Delete")) {

                deleteCart(request);

            }
        }

        //response.sendRedirect("ShoppingCart.jsp");
        request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
    }

    protected void addToCart(HttpServletRequest request) {

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        ItemDAOImpl itemDAO = new ItemDAOImpl(ConnectionManager.init(this.getServletContext()));
        Item temp = itemDAO.getItemByID(id);
        temp.setQuantity(1);

        ShoppingCart shoppingCart;
        Object objShoppingCart = session.getAttribute("cart");

        if (objShoppingCart != null) {
            shoppingCart = (ShoppingCart) objShoppingCart;
        } else {
            shoppingCart = new ShoppingCart();
            session.setAttribute("cart", shoppingCart);
        }
        
        System.out.println("shopping cart items: "+shoppingCart.getLineItemCount());
        
        shoppingCart.addCartItem(temp);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));

        ShoppingCart shoppingCart = null;

        Object objShoppingCart = session.getAttribute("cart");

        if (objShoppingCart != null) {

            shoppingCart = (ShoppingCart) objShoppingCart;

        } else {

            shoppingCart = new ShoppingCart();
        }
        shoppingCart.updateCartItem(itemIndex, quantity);
    }

    protected void deleteCart(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
        ShoppingCart shoppingCart = null;

        Object objShoppingCart = session.getAttribute("cart");

        if (objShoppingCart != null) {
            shoppingCart = (ShoppingCart) objShoppingCart;
        } else {
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.deleteCartItem(itemIndex);
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
