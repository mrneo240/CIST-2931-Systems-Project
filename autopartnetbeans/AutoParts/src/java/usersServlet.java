
import autopartstore.CustomerDAOImpl;
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

/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
/**
 *
 * @author Hayden Kowalchuk
 */
@WebServlet("/userServlet")
public class usersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    String lastMessage;
    private Statement querySmt = null;
    private ResultSet result = null;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        // Database operations using JDBC
        try {
            //ensure we have a connection to the DB
            Connection temp = ConnectionManager.init(this.getServletContext());
            
            request.setAttribute("customers", customerDAO.getAllCustomers());
                request.getRequestDispatcher("/listcustomers.jsp").forward(
                        request, response);

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

    }
