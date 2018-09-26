<%-- 
    Document   : newsignup
    Created on : Sep 16, 2018, 2:57:12 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

            <div class='main-container'>
                 <c:if test="${requestScope.success}">
                <div class="jumbotron">
                    <h1>New Registration!</h1>
                    <hr>
                    <p>Welcome to AutoPartsStore.com..... blah blah blah</p>
                    <p><a class="btn btn-primary btn-lg" role="button" href="#" data-toggle="modal" data-target="#login-modal" data-dismiss="modal">Login</a></p>
                </div>
                 </c:if>
                <c:if test="${!requestScope.success}">
                <div class="jumbotron">
                    <h1>Error in Registration!</h1>
                    <hr>
                    <p>Err... Let's correct the issues then try again ..... blah blah blah</p>
                    <p><a class="btn btn-primary btn-lg" role="button" href="#" data-toggle="modal" data-target="#register-modal" data-dismiss="modal">Register New Account</a></p>
                </div>
                 </c:if>
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
        