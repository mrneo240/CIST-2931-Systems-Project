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
    <h1>Shopping Cart</h1>

    <h2>Shopping Cart List</h2>


    <c:if test="${cart.getLineItemCount()==0 || cart == null}">
        <h2>Cart is currently empty!</h2>
    </c:if>
    <c:if test="${cart.getLineItemCount() > 0 }">
        <table>
            <tr>
                <td>Department</td>
                <td>Part Name</td>
                <td>Description</td>
                <td>Quantity</td>
                <td>Unit Price</td>
                <td>Total Price</td>
            </tr>
            <c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter">
                <form action="ShoppingCartServlet" method="POST" name="item">
                    <tr>
                        <td>${cartItem.getDept()}</td>
                        <td>${cartItem.getName()}</td>
                        <td>desc</td>
                        <td>
                            <input type='hidden' name='itemIndex' value='<c:out value="${counter.count-1}" />'>
                            <input type='text' name='quantity' value='${cartItem.getQuantity()}'>
                            <input type="submit" name="action" value="Update"><br />
                            <input type="submit" name="action" value="Delete"
                        </td>
                        <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getPrice()}"/></td>
                        <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></td>
                    </tr>
                </form>
            </c:forEach>
            <tr>
                <td> </td>
                <td> </td>
                <td>Subtotal: $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTotal()}"/></td>
            </tr>
<<<<<<< HEAD
        </c:if>
        <c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter">
            <form action="ShoppingCartServlet" method="POST" name="item">
                <tr>
                    <td>${cartItem.getDept()}</td>
                    <td>${cartItem.getName()}</td>
                    <td>desc</td>
                    <td>
                        <input type='hidden' name='itemIndex' value='<c:out value="${counter.count-1}" />'>
                        <input type='text' name='quantity' value='${cartItem.getQuantity()}'>
                        <input type="submit" name="action" value="Update"><br />
                        <input type="submit" name="action" value="Delete">
                    </td>
                    <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getPrice()}"/></td>
                    <td>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></td>
                </tr>
            </form>
        </c:forEach>
        <tr>
            <td> </td>
            <td> </td>
            <td>Subtotal: $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTotal()}"/></td>
        </tr>
    </table>
        <Form action="OrderReview.jsp" method="POST">
            <input type="submit" name="action" value="Order">
        </Form>
=======
        </table>
    </c:if>

>>>>>>> e7af7889efb47cd545f00cc5339367a07479275c

</div>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
