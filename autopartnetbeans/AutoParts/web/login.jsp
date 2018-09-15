<%-- 
    Document   : login
    Created on : Sep 5, 2018, 2:27:52 PM
    Author     : Hayden Kowalchuk
--%>

 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example</title>
</head>
<body>
<form action="loginServlet" method="post">
<table>
<tr>
<td>User name :</td>
<td><input type="text" name="user"/></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="password" name="pass"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login"></td>
</tr>
</table>
</form>
    <br><hr>
    <form action="usersServlet" method="post">
         Customer ID: <input type="text" name="cid"><br>
<input type="submit" value="List Specific User">
</form>
</body>
</html>