
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author Java2db.com
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String user_ID_from_DB = "";
    String user_password_from_DB = "";

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    String lastMessage;
private  Statement querySmt = null;
    private  ResultSet result = null;
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("id").trim();
        String password = request.getParameter("password").trim();
        // Database operations using JDBC
        try {
            //ensure we have a connection to the DB
            Connection temp = ConnectionManager.init(this.getServletContext());
            
            System.out.println("connected successfully");
            System.out.printf("Looking for %s with pass: %s\n", user_id, password);
            // Select user from database to check user login id and password
            querySmt = temp.createStatement();
            result = querySmt
                    .executeQuery("select * from Customers where Username = '" + user_id + "'");
            System.out.println("select * from Customers where Username = '" + user_id + "'");
            String name ="";
            while (result.next()) {
                user_ID_from_DB = result.getString("Username").trim();
                user_password_from_DB = result.getString("Password")
                        .trim();
                name = result.getString("Name").trim();
                System.out.println(user_ID_from_DB + " "
                        + user_password_from_DB);
            }
            // Database operations completed
            if (user_id.equals(user_ID_from_DB)
                    && password.equals(user_password_from_DB)) {
                request.setAttribute("name", name);
                request.getRequestDispatcher("/success.jsp").forward(
                        request, response);
            } else {
                request.getRequestDispatcher("/failure.jsp").forward(
                        request, response);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                result.close();
                querySmt.close();
            } catch(NullPointerException e){{}
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
