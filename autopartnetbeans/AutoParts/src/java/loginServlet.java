
import autopartstore.Customer;
import autopartstore.CustomerDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author Java2db.com
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String usernameDB = "";
    String passwordDB = "";

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    String lastMessage;
    private Statement querySmt = null;
    private ResultSet result = null;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("action").equals("login")) {

            String user_id = request.getParameter("user").trim();
            String password = request.getParameter("pass").trim();
            Customer customer = null;
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));

            // Database operations using JDBC
            try {
                //ensure we have a connection to the DB
                Connection temp = ConnectionManager.init(this.getServletContext());

                // Select user from database to check user login id and password
                querySmt = temp.createStatement();
                result = querySmt.executeQuery("select * from Customers where Username = '" + user_id + "' AND Password = '" + password + "'");
                while (result.next()) {
                    customer = customerDAO.getCustomerByID(result.getInt("id"));
                    session.setAttribute("customer", customer);
                    session.setAttribute("loginID", result.getInt("id"));
                }
                // Database operations completed
                
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    result.close();
                    querySmt.close();
                } catch (NullPointerException e) {
                    {
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } else {
            session.removeAttribute("loginID");
            session.removeAttribute("customer");
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
