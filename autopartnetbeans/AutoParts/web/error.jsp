<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page isErrorPage="true"%>
<c:set var="errorPage" value="true" />
<%@ include file="WEB-INF/headerTemplate.jsp" %>

            <div class='main-container'>
                <div class="error-wall load-error">
                    <div class="error-container">
                        <h1>oh no...</h1>
                        <h3>We have had an error</h3>
                        <h4>Error 404</h4>
                        <p>Sorry...please check back (click refresh) in just a moment.</p>
                        <p>If you are tyring to process an order, we recommend you call<br> AutoParts' Customer Support team at (800) 111-1111.<br> Or email at support@autoparts.com</p>
                    </div>
                </div>
            </div>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
</body>
</html>