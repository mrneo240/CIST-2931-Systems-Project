<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="headerTemplate.jsp" %>

<div class='main-container'>
    <div id="slideshow-wrapper" class='relative'>
        <div class='search-form'>
            <h2>Search for parts</h2>
            <form class="form-horizontal col-sm-12 col-md-10 col-lg-8 col-cen" action="searchItemServlet" method="post">
                <div class="form-group">
                    <div class="col-cen">
                        <input type="text" class="form-control" name="searchTerm" placeholder="Search for parts">
                    </div>
                </div>
                <div class="form-group">
                    <div class="pull-right">
                        <button type="submit" class="btn btn-lg btn-warning">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <div id="slideshow">
            <img src="https://images.pexels.com/photos/924675/pexels-photo-924675.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"></img>
            <img src="https://images.pexels.com/photos/159275/macro-focus-cogwheel-gear-159275.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></img>
            <img src="https://images.pexels.com/photos/191738/pexels-photo-191738.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></img>
        </div>
        <div style="text-align: center">
            <div id="circle1" class="circle"></div>
            <div id="circle2" class="circle"></div>
            <div id="circle3" class="circle"></div>
        </div>
    </div>
</div>
<div class="row text-center feature-imgs">
    <h2>Feature Items</h2>
    <c:if test="${featureItems != null}">
            <c:forEach items="${featureItems}" var="item">
                <div class="col-sm-4 col-xs-6">
                    <div class="thumbnail">
                        <form action="ShoppingCartServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="${item.getPartCode()}"/>
                            <input type="hidden" name="department" value="${item.getDept()}" />
                            <div class="ThumbContainer"><img height="inherit" width="100%"  src="${item.getphoto()}"></div>
                            <p><strong>${item.getName()}</strong></p>
                            <p>${item.getDesc()}</p>
                            <button class="btn" name="addToCart" type="submit"><strong>$${item.getPrice()}<input type="hidden" name="price" value="${item.getPrice()}"/></strong> - Add to cart</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
</div>
<%@ include file="footerTemplate.jsp" %>
