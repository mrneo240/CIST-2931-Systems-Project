<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page isErrorPage="true"%>
<c:set var="notFoundPage" value="true" />
<%@ include file="WEB-INF/headerTemplate.jsp" %>

            <div class='main-container'>
                <div class="text-wrapper">
                    <div class="title" data-content="404">
                        404
                    </div>

                    <div class="subtitle">
                        Oops, the page you're looking for doesn't exist.
                    </div>
                    <br><br>

                    <div class="buttons">
                        <a class="button" href="./">Go to homepage</a>
                    </div>
                </div>
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
    </body>
</html>