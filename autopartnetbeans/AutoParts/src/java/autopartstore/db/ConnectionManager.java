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
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;

/**
 *
 * @author Hayden Kowalchuk
 */
public class ConnectionManager {
    
    private static boolean online = true;
    private static ServletContext context = null;

    public ConnectionManager(ServletContext con) {
        context = con;
        ConnectionManager.online = true;
    }
    public ConnectionManager(boolean online){
        ConnectionManager.online = online;
    }

    public static Connection init(ServletContext con) {
        ConnectionManager temp = new ConnectionManager(con);
        return ConnectionManager.getConnection();
    }

    private static Connection connection = null;
    private static boolean databaseConnected = false;

    public static Connection getConnection() {
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
            String path = "";
            if(ConnectionManager.online){
                 path = context.getRealPath("/");
            } else {
                path = "resources";
            }
            String dbURL = "jdbc:ucanaccess://" + path + "/AutoPart1.mdb";
            try {
                //Open our database file using ucanaccess
                connection = DriverManager.getConnection(dbURL);
                //Create a new Statement that we can use to retrieve data
                databaseConnected = true;
            } catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database", ex);
            }
        }
        return connection;
    }

    public void closeDBConnection() {
        databaseConnected = false;
        //Enclose within a try/catch because closing might cause an exception
        try {
            //Safely close everything SQL related because we are done
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * @return the query
     * @throws java.sql.SQLException
     */
    public static Statement getQuery() throws SQLException {
        return connection.createStatement();
    }

}
