<%-- 
    Document   : listusers
    Created on : Sep 8, 2018, 6:30:22 PM
    Author     : Hayden Kowalchuk
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="autopartstore.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Customers:</h1>
        <% Set<Customer> customers = (Set<Customer>) request.getAttribute("customers");

            for (Customer customer : customers) {
                out.print("Id: " + customer.getcid());
                out.print("<br/>");
                out.print("Name: " + customer.getcustName());
                out.print("<br/>");
                out.print("email: " + customer.getemail());

                out.print("<br/>");
                out.print("<br/>");
            }

        %>
    </body>
</html>
