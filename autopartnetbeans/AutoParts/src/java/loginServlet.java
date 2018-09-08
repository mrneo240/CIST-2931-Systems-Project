
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
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
    Connection connection = null;
    Statement querySmt = null;
    ResultSet result = null;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    //Create our sql specific vars but leave them null
    Statement query = null;
    ResultSet results = null;
    boolean databaseConnected = false;
    String lastMessage;

    public boolean setupAndConnectDB() throws SQLException {
        lastMessage = "";
        if (!databaseConnected) {
            //Check if ucanaccess if actually available and 
            //error out before we even try to use it
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException e) {
                System.out.printf("Fatal Error: UCanAccess not found.\n");
                System.exit(1);
            }

            //SQL Data
            //Setup basic variables that will be used
            ServletContext context = this.getServletContext();
            String path = context.getRealPath("/");
            String dbURL = "jdbc:ucanaccess://" + path + "/AutoPart1.mdb";

            //UCanAccess is available, ok lets use it
            //Open our database file using ucanaccess
            connection = DriverManager.getConnection(dbURL);
            //Create a new Statement that we can use to retrieve data
            query = connection.createStatement();
            databaseConnected = true;
        }

        return databaseConnected;
    }

    public void closeDBConnection() {
        databaseConnected = false;
        //Enclose within a try/catch because closing might cause an exception
        try {
            //Safely close everything SQL related because we are done
            if (results != null) {
                results.close();
            }
            query.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("id").trim();
        String password = request.getParameter("password").trim();
        // Database operations using JDBC
        try {
            //ensure we have a connection to the DB
            setupAndConnectDB();

            System.out.println("connected successfully");
            System.out.printf("Looking for %s with pass: %s\n", user_id, password);
            // Select user from database to check user login id and password
            querySmt = connection.createStatement();
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
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
