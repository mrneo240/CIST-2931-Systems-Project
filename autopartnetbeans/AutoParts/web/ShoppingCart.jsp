<%-- 
    Document   : ShoppingCart
    Created on : Sep 22, 2018, 2:29:12 PM
    Author     : Michelle (Boobin) Choi
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

<div class='main-container'>
    <div class="row form-group">
        <div class="container">
            <div class="col-xs-12">
                <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                    <li class="active"><a href="ShoppingCart.jsp" >
                            <h4 class="list-group-item-heading">Step 1</h4>
                            <p class="list-group-item-text">Shopping Cart</p>
                        </a></li>
                    <li class="disabled"><a href="OrderConfirm.jsp" onclick="javascript:return false">
                            <h4 class="list-group-item-heading">Step 2</h4>
                            <p class="list-group-item-text">Delivery and Payment Details</p>
                        </a></li>
                    <li class="disabled"><a href="" onclick="javascript:return false">
                            <h4 class="list-group-item-heading">Step 3</h4>
                            <p class="list-group-item-text">Order Confirmation</p>
                        </a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8">
                        <!--SHIPPING METHOD-->
                        <div class="panel panel-default">
                            <div class="panel-heading text-center"><h4>Current Cart</h4></div>
                            <div class="panel-body">
                                <table class="table borderless">
                                    <thead>
                                        <tr>
                                            <td><strong>Your Cart: # item</strong></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter">
                                        <form action="ShoppingCartServlet" method="POST" name="item">
                                            <input type='hidden' name='itemIndex' value='<c:out value="${counter.count-1}" />'>
                                            <tr>
                                                <td class="col-md-3">
                                                    <div class="media">
                                                        <a class="thumbnail pull-left" href="#"> <img class="media-object" src="https://loremflickr.com/320/240/${cartItem.getDept()}?id=${cartItem.getPrice()}" style="width: 72px; height: 72px;"> </a>
                                                        <div class="media-body">
                                                            <h5 class="media-heading"> ${cartItem.getName()}</h5>
                                                            <h5 class="media-heading"> ${cartItem.getID()}</h5>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getPrice()}"/></td>
                                                <td class="text-center"><input type='text' name='quantity' value='${cartItem.getQuantity()}'><input type="submit" name="action" value="Update"></td>
                                                <td class="text-right"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></td>
                                                <td class="text-right"><button type="submit" name="action" value="Delete" class="btn btn-danger">Remove</button></td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table> 
                            </div>
                        </div>
                        <!--SHIPPING METHOD END-->
                    </div>
                    <div class="col-md-4">
                        <!--REVIEW ORDER-->
                        <div class="panel panel-info">
                            <div class="panel-heading text-center">
                                <h4>Review Order</h4>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <strong>Subtotal (# item)</strong>
                                    <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderSubTotal()}"/></span></div>
                                </div>
                                <div class="col-md-12">
                                    <strong>Tax</strong>
                                    <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTax()}"/></span></div>
                                </div>
                                <div class="col-md-12">
                                    <small>Shipping</small>
                                    <div class="pull-right"><span>-</span></div>
                                    <hr>
                                </div>
                                <div class="col-md-12">
                                    <strong>Order Total</strong>
                                    <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTotal()}"/></span></div>
                                    <hr>
                                </div>
                                <a class="btn btn-primary btn-lg col-md-12" href="OrderConfirm.jsp">Checkout</a>
                            </div>                </div>
                        <!--REVIEW ORDER END-->
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
