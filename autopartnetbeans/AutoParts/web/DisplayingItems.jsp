<%-- 
    Document   : DisplayingItems
    Created on : Sep 15, 2018, 1:20:51 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

            <div class='main-container'>
                <h1>Searching for <p class="font-weight-bold">${requestScope.searchTerm}</p></h1>
                <c:set var="attractImgs" 
                       value="${['https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png', 
                                'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg',
                                'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg']}"
                       scope="application" />
                
                <div class="row text-center feature-imgs">
                    <c:if test="${searchItems != null}">
                    <c:forEach items="${items}" var="item">
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png" alt="Paris">
                            <p><strong>Full Synthetic Oil</strong></p>
                            <p>Extra info</p>
                            <button class="btn">Add to cart</button>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg" alt="New York">
                            <p><strong>Alternator</strong></p>
                            <p>Extra info</p>
                            <button class="btn">Add to cart</button>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg" alt="San Francisco">
                            <p><strong>Pulley</strong></p>
                            <p>Extra info</p>
                            <button class="btn">Add to cart</button>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${searchItems == null}">
                     <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="./img/Garage-Dark-Underground-Subway-Closed-Store-769792.jpg" alt="Nothing Found">
                            <p><strong>No Items Found!</strong></p>
                            <p>Please try different Search Terms</p>
                        </div>
                    </div>
                    </c:if> 
                </div>
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
    </body>
</html>