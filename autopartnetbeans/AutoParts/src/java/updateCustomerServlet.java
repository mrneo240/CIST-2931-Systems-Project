
import autopartstore.Customer;
import autopartstore.CustomerDAOImpl;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hayden Kowalchuk
 */
public class updateCustomerServlet extends HttpServlet {

    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    protected void finishRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        OrderDAOImpl orderDAO = new OrderDAOImpl(ConnectionManager.init(this.getServletContext()));
        
        if (session.getAttribute("loginID") != null) {
            int custID = (int) session.getAttribute("loginID");
            Set<Order> orders = orderDAO.getAllOrdersByCustomer(custID);
            //this.getServletContext().log("Finding orders for custID:"+(int) session.getAttribute("loginID"));
            orders.forEach((order) -> {
                this.getServletContext().log(order.toString());
            });

            Set<OrderJSON> ordersFINAL = new HashSet<>();
            for (Order temp : orders) {
                ordersFINAL.add(gson.fromJson(temp.getOrderJSON(), OrderJSON.class));
            }
            ordersFINAL.forEach((temp) -> {
                temp.synchronize();
            });

            session.setAttribute("orders", ordersFINAL);
        }

        request.getRequestDispatcher("WEB-INF/updateprofile.jsp").forward(request, response);
    }

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
        finishRequest(request, response);
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

        boolean success = false;
        HttpSession session = request.getSession();

        if (request.getParameter("action").equals("update")) {

            String name = request.getParameter("fname").trim() + " " + request.getParameter("lname").trim();
            String email = request.getParameter("email").trim();
            //String username = request.getParameter("username").trim();
            String password = request.getParameter("pass").trim();
            String creditc = request.getParameter("creditc").trim();
            String address = request.getParameter("address").trim();
            Customer customer = null;
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));

            // Database operations using JDBC
            try {
                //ensure we have a connection to the DB
                customer = (Customer) session.getAttribute("customer");
                if (name.length() > 0) {
                    customer.setcustName(name);
                } else  ;
                if (email.length() > 0) {
                    customer.setemail(email);
                } else  ;
                if (password.length() > 0) {
                    customer.setpassword(password);
                } else  ;
                if (creditc.length() > 0) {
                    customer.setcreditC(creditc);
                } else  ;
                if (address.length() > 0) {
                    customer.setaddress(address);
                } else  ;

                success = customerDAO.updateCustomer(customer);
                if (email.equalsIgnoreCase("error")) {
                    success = false;
                }
                if (success) {
                    request.setAttribute("displayAlert", true);
                    request.setAttribute("alertType", "alert-success");
                    request.setAttribute("alertMessage", "Account succesfully updated!"/*<a href=\"#\" class=\"alert-link\">Test Link</a>*/);
                } else {
                    request.setAttribute("displayAlert", true);
                    request.setAttribute("alertType", "alert-danger");
                    request.setAttribute("alertMessage", "Some error occurred somewhere! uh oh!");
                }
            } catch (NullPointerException e) {
                {
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        request.setAttribute("jsScript", "$('a[href=\"#user\"]').trigger('click');");
        finishRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Updates a Customer Object in the DB";
    }// </editor-fold>

}
