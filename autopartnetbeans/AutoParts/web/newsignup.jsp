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
                <h1>New Registration</h1>
                <div>
                    <c:if test="${!requestScope.success}">
                        <div class="alert alert-danger fade in">
                            <strong>Error!</strong> ${requestScope.lastMessage}
                        </div>
                    </c:if>
                    <c:if test="${requestScope.success}">
                        <div class="alert alert-success" role="alert">
                            <strong>Success!</strong> ${requestScope.lastMessage} <a href="#" class="alert-link" data-toggle="modal"  data-target="#login-modal" data-dismiss="modal"><br>Please proceed to Login</a> if you'd like.
                        </div>
                    </c:if>
                </div>
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
    </body>
</html>