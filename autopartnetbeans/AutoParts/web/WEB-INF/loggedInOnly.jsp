<%-- 
    Document   : loggedInOnly
    Created on : Sep 17, 2018, 12:58:36 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <c:if test="${loginID == null}">
    <c:redirect url="/index.jsp"/>
 </c:if>