/*
/*****************************
* Hayden Kowalchuk - 900450331
* CIST 2372-60273
* Lab X: XXXXXXXXXXXXX	
* Description of file and lab.
* Copyright (C) 2018 Hayden Kowalchuk
***************************** */
package autopartstore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

/**
 *
 * @author Hayden Kowalchuk
 */
public class ConnectionManager {
    
    private static ServletContext context = null;
    public ConnectionManager(ServletContext con){
            context = con;
    }
    
    public static Connection init(ServletContext con) throws SQLException{
        ConnectionManager temp = new ConnectionManager(con);
        return ConnectionManager.getConnection();
    }
    
    private static Connection connection = null;
    //Create our sql specific vars but leave them null
    private static boolean databaseConnected = false;
    
    private static String lastMessage;
    
    public static Connection getConnection() throws SQLException {
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
            //ServletContext context = this.getServletContext();
            String path = context.getRealPath("/");
            String dbURL = "jdbc:ucanaccess://" + path + "/AutoPart1.mdb";

            //Open our database file using ucanaccess
            connection = DriverManager.getConnection(dbURL);
            //Create a new Statement that we can use to retrieve data
            databaseConnected = true;
        }
        return connection;
    }

    public void closeDBConnection() {
        databaseConnected = false;
        //Enclose within a try/catch because closing might cause an exception
        try {
            //Safely close everything SQL related because we are done
            /*if (results != null) {
                results.close();
            }*/
            //getQuery().close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * @return the query
     */
    public static Statement getQuery() throws SQLException {
        return connection.createStatement();
    }

    
}
