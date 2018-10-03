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
            <div class="form-group">
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
                   <div class="col-md-8 col-sm-8 col-xs-12">
                        <!--SHIPPING METHOD-->
                        <div class="panel panel-default">
                            <div class="panel-heading text-center"><h4>Current Cart</h4></div>
                            <div class="panel-body">
                                <c:if test="${cart.getLineItemCount() == 0 || cart == null}">
                                    <div class="row" id="box-search">
                                        <div class="text-center">
                                            <img src="img/empty-shopping-cart.png" alt="" width="50%" height="50%" style="margin-right: auto;margin-left: auto;" class="img-responsive">
                                            <div class="caption well well-sm">
                                                <p>Your Shopping cart is empty, Let's find some items to add to it!<h3><a href="index.jsp">Take me There!</a></h3></p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${cart.getLineItemCount() > 0}">
                                    <table class="table borderless">
                                        <thead>
                                            <tr>
                                                <td><strong>Your Cart: ${cart.getLineItemCount()} item(s)</strong></td>
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
                                                    <td class="col-md-5">
                                                        <div class="media">
                                                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="https://loremflickr.com/320/240/${cartItem.getDept()}?id=${cartItem.getPrice()}" style="width: 72px; height: 72px;"> </a>
                                                            <div class="media-body">
                                                                <h5 class="media-heading"> ${cartItem.getName()}</h5>
                                                                <h5 class="media-heading"> ${cartItem.getPartCode()}</h5>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="text-center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getPrice()}"/></td>
                                                    <td class="text-center col-md-2 col-sm-3 col-xs-4"><div class="input-group">
                                                            <input type="text" class="form-control" placeholder="1" name="quantity" value='${cartItem.getQuantity()}'>
                                                            <div class="input-group-btn hidden-xs">
                                                                <button class="btn btn-default" type="submit" name="action" value="Update"><i class="fa fa-check-square"></i></button>
                                                            </div>
                                                        </div></td>
                                                    <td class="text-right"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></td>
                                                    <td class="text-right col-md-2"><button type="submit" name="action" value="Delete" class="btn btn-danger">Remove</button></td>
                                                </tr>
                                            </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                            </div>
                        </div>
                        <!--SHIPPING METHOD END-->
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <!--REVIEW ORDER-->
                        <div class="panel panel-info">
                            <div class="panel-heading text-center">
                                <h4>Review Order</h4>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <strong>Subtotal</strong>
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
                                <a class="btn btn-primary btn-lg col-md-12" href="OrderConfirm.jsp"<c:if test="${cart.getLineItemCount() == 0 || cart == null}"> disabled onClick="return false;"</c:if>>Checkout</a>
                                </div>                </div>
                            <!--REVIEW ORDER END-->
                        </div>

                   
                </div>
            </div>
        </div>
    </div>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
