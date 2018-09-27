
import autopartstore.Item;
import autopartstore.ItemDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class searchItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    private Statement querySmt = null;
    private ResultSet result = null;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("searchTerm");
        session.removeAttribute("searchItems");

        String searchTerm = request.getParameter("searchTerm").trim();
        Set<Item> items;
        ItemDAOImpl itemDAO = new ItemDAOImpl(ConnectionManager.init(this.getServletContext()));

        // Database operations using JDBC
        try {
            
            if (searchTerm.length() != 0) {
                session.setAttribute("searchTerm", searchTerm);
                items = itemDAO.getItemsBySearchParam(searchTerm);
                session.setAttribute("searchItems", items!= null ? (items.size() > 0 ? items : null) : null);
            } else {
                session.setAttribute("searchTerm", null);
                session.setAttribute("searchItems", null);
            }

        } // Database operations completed
        catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("displayingitems.jsp");
    }

}
