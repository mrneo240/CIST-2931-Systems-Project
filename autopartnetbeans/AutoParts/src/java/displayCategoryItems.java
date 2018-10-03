
import autopartstore.Item;
import autopartstore.ItemDAOImpl;
import autopartstore.db.ConnectionManager;
import java.io.IOException;
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
public class displayCategoryItems extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        String cat = request.getParameter("cat").trim().toLowerCase();
        session.setAttribute("searchTerm", cat.substring(0, 1).toUpperCase() + cat.substring(1));
        Set<Item> items;
        ItemDAOImpl itemDAO = new ItemDAOImpl(ConnectionManager.init(this.getServletContext()));

        // Database operations using JDBC
        try {
            
            if (cat.length() != 0) {
                if (cat.equals("all")){
                    items = itemDAO.getAllItems();
                } else{
                items = itemDAO.getAllItemsByDept(cat);}
                session.setAttribute("searchItems", items.size() > 0 ? items : null);
            } else {
                session.setAttribute("searchItems", null);
            }

        } // Database operations completed
        catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("displaydept.jsp");
    }

}
