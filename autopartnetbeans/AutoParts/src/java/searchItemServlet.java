
import autopartstore.Item;
import autopartstore.ItemDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
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

        String searchTerm = request.getParameter("searchTerm").trim();
        PrintWriter out = response.getWriter();
        out.println(searchTerm);
        out.println("SELECT * FROM engine WHERE (UPPER(partName) LIKE UPPER('%"+searchTerm+"%'))");
        Set<Item> items;
        ItemDAOImpl itemDAO = new ItemDAOImpl(ConnectionManager.init(this.getServletContext()));
        
        // Database operations using JDBC
        try {
            //items = itemDAO.getItemsBySearchParam(searchTerm);
            
            session.setAttribute("searchTerm", searchTerm);
            session.setAttribute("searchItems", itemDAO.getItemsBySearchParam(searchTerm));
        } // Database operations completed
        catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/displayingitems.jsp").forward(request, response);
    }

}
