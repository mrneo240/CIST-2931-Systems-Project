<%-- 
    Document   : orderConfirm
    Created on : Oct 1, 2018, 12:33:48 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="headerTemplate.jsp" %>
<div class='main-container'>
    <div class="jumbotron">
        <h1>Order Placed!</h1>
        <hr>
        <p>${json}</p>
        <br>
        <c:forEach items="${items}" var="item">
            ${item.getItem().toString()}
        </c:forEach>
    </div>
</div>
<%@ include file="footerTemplate.jsp" %>
