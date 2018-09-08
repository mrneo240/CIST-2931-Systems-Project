
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

        CustomerDAOImpl customerDAO = new CustomerDAOImpl(ConnectionManager.init(this.getServletContext()));
        // Database operations using JDBC

        //ensure we have a connection to the DB
        request.setAttribute("customers", customerDAO.getAllCustomers());
        request.getRequestDispatcher("/listcustomers.jsp").forward(request, response);
    }
}
