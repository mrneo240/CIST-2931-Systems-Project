<%-- 
    Document   : DisplayingItems
    Created on : Sep 15, 2018, 1:20:51 PM
    Author     : Hayden Kowalchuk
    Edited     : Levi Llewellyn
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

<div class='main-container'>
    <h1>Searching for <p class="font-weight-bold">${searchTerm != null ? searchTerm : "No Search Entered"}</p></h1>
        <c:set var="attractImgs" 
               value="${['https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png', 
                        'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg',
                        'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg']}"
               scope="application" />
    <div class="col-md-12 col-xs-12">
        <hr class="line">
    </div>
    <div class="row text-center feature-imgs">
        <c:if test="${searchItems != null}">
            <c:forEach items="${searchItems}" var="item">
                <%
                    int randomNum = (int) (java.lang.Math.random() * (3));
                    pageContext.setAttribute("randomNum", randomNum);
                %>
                <c:set var="random" value="${randomNum}"/>
                <div class="col-md-3 col-sm-4 col-xs-6">
                    <div class="thumbnail">
                        <form action="ShoppingCartServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="${item.getPartCode()}"/>
                            <input type="hidden" name="department" value="${item.getDept()}" />
                            <div class="ThumbContainer"><img height="inherit" width="100%"  src="${attractImgs[random]}"></div>
                            <p><strong>${item.getName()}</strong></p>
                            <p>${item.getDesc()}</p>
                            <button class="btn" name="addToCart" type="submit"><strong>$ ${item.getPrice()}<input type="hidden" name="price" value="${item.getPrice()}"/></strong> - Add to cart</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
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
