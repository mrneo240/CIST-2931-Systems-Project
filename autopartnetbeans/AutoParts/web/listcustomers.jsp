<%-- 
    Document   : listusers
    Created on : Sep 8, 2018, 6:30:22 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Customers:</h1>
        <c:if test = "${requestScope.id == null}">
            <c:forEach items="${customers}" var="customer">
                <p>
                    <c:out value="Name: ${customer.getcustName()}" /><br>
                    <c:out value="ID: ${customer.getcid()}" /><br>
                    <c:out value="Email: ${customer.getemail()}" /><br>
                    <c:out value="Login: ${customer.getusername()}:${customer.getpassword()}" /><br>
                    <br>
                </p>
            </c:forEach>
        </c:if>
        <c:if test = "${requestScope.id != null}">
            <p>
                <c:out value="Name: ${customer.getcustName()}" /><br>
                <c:out value="ID: ${customer.getcid()}" /><br>
                <c:out value="Email: ${customer.getemail()}" /><br>
                <c:out value="Login: ${customer.getusername()}:${customer.getpassword()}" /><br>
                <br>
            </p>
        </c:if>
    </body>
</html>
