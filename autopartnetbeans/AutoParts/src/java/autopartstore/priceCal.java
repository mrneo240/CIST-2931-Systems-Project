/*
    Document   : Price Calcultor
    Created on : Sep 22, 2018.
    Author     : Levi Llewellyn
 */
package autopartstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class priceCal {

    private double sum;

    // test array
    double[] sub = {5, 5, 8, 9, 15};

    /*
    
      try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/DentistOfficeACCDB.accdb");
            Statement stmt = con.createStatement();
            String sql = "select * from Dentists WHERE id = " + "'" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                denid = rs.getString(1);
                passwd = rs.getString(5);
                fname = rs.getString(2);
                lname = rs.getString(3);
                email = rs.getString(4);
                office = rs.getString(6);

            }
            con.close();

        } catch (Exception ae) {
            System.out.println(ae);
            ae.printStackTrace();
        } */
        
        
    /* database connection that pulls the prices of each 
    item in the cart and fills the array
     */
    
    public double pcal() {
        int i = 0;
        while (i < sub.length) {
            sum += sub[i];
            i++;
        }
        sum = sum + (sum * .07);
        return sum;
    }
    
    // Tester main 
    public static void main(String[] args) {
        double total;
        priceCal bb = new priceCal();
        total = bb.pcal();
        System.out.println("$" + total);
    }

}
