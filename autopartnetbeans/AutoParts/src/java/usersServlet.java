import autopartstore.CustomerDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hayden Kowalchuk
 */
@WebServlet("/usersServlet")
public class usersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));

        String custID = request.getParameter("cid").trim();
        if (custID.length() > 0) {
            int id = Integer.parseInt(custID);
            request.setAttribute("customer", customerDAO.getCustomerByID(id));
            request.setAttribute("id", id);
        } else {
            request.setAttribute("customers", customerDAO.getAllCustomers());
        }
        request.getRequestDispatcher("/listcustomers.jsp").forward(request, response);
    }
}
