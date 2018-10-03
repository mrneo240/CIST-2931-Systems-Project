
import autopartstore.Customer;
import autopartstore.CustomerDAOImpl;
import autopartstore.OrderPicker;
import autopartstore.OrderPickerDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hayden Kowalchuk
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void finishRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect(request.getHeader("referer"));
        String ref = "";
        if (request.getHeader("referer") != null) {
            String referrerArr[] = request.getHeader("referer").split("/");
            ref = referrerArr[referrerArr.length - 1];
        }
        if (ref.equals("login.jsp") || ref.equals("createNewSignup.jsp") || !ref.contains(".jsp")) {
            ref = "index.jsp";
        }
        request.getRequestDispatcher(ref).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        finishRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("action").equals("login")) {
            session.removeAttribute("loginID");
            session.removeAttribute("customer");
            String user_id = request.getParameter("user").trim();
            String password = request.getParameter("pass").trim();

            CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));
            OrderPickerDAOImpl pickerDAO = new OrderPickerDAOImpl(ConnectionManager.init(this.getServletContext()));
            Customer customer = customerDAO.getCustomerByUsername(user_id);

            if (customer.getcustName().equals("ERROR")) {
                //Found as a picker though
                Customer orderpicker = (Customer) pickerDAO.getOrderPickerByUsername(user_id);
                if (orderpicker != null) {
                    if (orderpicker.getpassword().equals(password)) {
                        session.setAttribute("customer", orderpicker);
                        session.setAttribute("loginID", orderpicker.getcid());
                        session.setAttribute("admin", true);
                        finishRequest(request, response);
                        return;
                    }
                }
                //ERROR!
                request.setAttribute("displayAlert", true);
                request.setAttribute("alertType", "alert-danger");
                request.setAttribute("alertMessage", "Username not found!");
                finishRequest(request, response);
                return;
            }

            if (!customer.getpassword().equals(password)) {
                //ERROR!
                request.setAttribute("displayAlert", true);
                request.setAttribute("alertType", "alert-danger");
                request.setAttribute("alertMessage", "Passwords do not match!");
                finishRequest(request, response);
                return;
            }

            session.setAttribute("customer", customer);
            session.setAttribute("loginID", customer.getcid());

        } else {
            //Must be for Logout
            session.removeAttribute("loginID");
            session.removeAttribute("customer");
            session.removeAttribute("admin");
        }
        finishRequest(request, response);
    }

}
