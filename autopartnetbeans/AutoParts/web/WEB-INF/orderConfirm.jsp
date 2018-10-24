<%-- 
    Document   : orderConfirm
    Created on : Oct 1, 2018, 12:33:48 PM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="headerTemplate.jsp" %>
<div class='main-container'>
    <div class="jumbotron">
        <h1>Order Placed!</h1>
        <hr>
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-heading text"><h4 class="panel-title">Your Order is placed Today ( ${order.getDate()} )</h4></div>
                <div class="panel-heading text"><h4 class="panel-title">Order #${order.getID()}</h4></div>
            </div>
            <div class="panel-body">
                <table class="table borderless">
                    <tbody
                        <c:forEach var="item" items="${order.items}" varStatus="counter">
                            <c:set var = "cartItem" value = "${item.getItem()}"/>
                            <tr>
                                <td class="col-md-5">
                                    <div class="media">
                                        <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${cartItem.getphoto()}" style="width: 72px; height: 72px;"> </a>
                                        <div class="media-body">
                                            <h5 class="media-heading"> ${cartItem.getName()}</h5>
                                            <h5 class="media-heading"> ${cartItem.getPartCode()}</h5>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getPrice()}"/></td>
                                <td class="text-center col-md-1 col-s-2 col-xs-2"><div class="input-group">
                                        <input type="text" class="form-control" placeholder="1" name="quantity" value='${cartItem.getQuantity()}' disabled>
                                    </div></td>
                                <td class="text-right"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <hr>
                <div class="pull-right col-md-3 col-xs-6">
                    <div class="">
                        <strong>Subtotal</strong>
                        <div class="pull-right"><span>$</span><span>${order.getOrderSubTotal()}</span></div>
                    </div>
                    <div class="">
                        <small>Tax</small>
                        <div class="pull-right"><span>$</span><span>${order.getOrderTax()}</span></div>
                    </div>
                    <div class="">
                        <small>Shipping</small>
                        <div class="pull-right"><span>-</span></div>
                    </div>
                </div>
            </div>
            <div class="panel-footer" style="overflow:hidden;">
                <div class="pull-right col-md-3 col-xs-6">
                    <strong>Total: </strong><div class="pull-right"><span>$</span><span>${order.getOrderTotal()}</span></div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footerTemplate.jsp" %>
