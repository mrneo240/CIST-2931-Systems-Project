<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>
<c:set var="attractImgs" 
       value="${['https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png', 
                'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg',
                'https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg']}"
       scope="application" />
<div class='main-container'>
    <h1>${param.cat}</h1>
    <div class="row text-center feature-imgs">
        <h2>Feature Items</h2>
        <c:if test="${featureItems != null}">
            <c:forEach items="${featureItems}" var="item">
                <%
                    int randomNum = (int) (java.lang.Math.random() * (3));
                    pageContext.setAttribute("randomNum", randomNum);
                %>
                <c:set var="random" value="${randomNum}"/>
                <div class="col-sm-4 col-xs-6">
                    <div class="thumbnail">
                        <form action="ShoppingCartServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="${item.getPartCode()}"/>
                            <input type="hidden" name="department" value="${item.getDept()}" />
                            <div class="ThumbContainer"><img height="inherit" width="100%"  src="${attractImgs[random]}"></div>
                            <p><strong>${item.getName()}</strong></p>
                            <p>${item.getDesc()}</p>
                            <button class="btn" name="addToCart" type="submit"><strong>$${item.getPrice()}<input type="hidden" name="price" value="${item.getPrice()}"/></strong> - Add to cart</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <div class="col-md-12 col-xs-12">
            <hr class="line">
        </div>
        <c:if test="${searchItems != null}">
            <c:forEach items="${searchItems}" var="item">
                <%
                    int randomNum = (int) (java.lang.Math.random() * (3));
                    pageContext.setAttribute("randomNum", randomNum);
                %>
                <c:set var="random" value="${randomNum}"/>
                <div class="col-md-3 col-sm-4 col-xs-6"> 
                    <form class="thumbnail" action="ShoppingCartServlet" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="id" value="${item.getPartCode()}"/>
                        <input type="hidden" name="department" value="${item.getDept()}" />
                        <div class="ThumbContainer"><img height="inherit" width="100%"  src="${attractImgs[random]}"></div>
                        <p><strong>${item.getName()}</strong></p>
                        <p>${item.getDesc()}</p>
                        <button class="btn" name="addToCart" type="submit"><strong>$${item.getPrice()}<input type="hidden" name="price" value="${item.getPrice()}"/></strong> - Add to cart</button>
                        
                    </form>
                </div>
                
            </c:forEach>
        </c:if>
    </div>
</div>
<c:set var="searchTerm" value="" scope="session"></c:set>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
