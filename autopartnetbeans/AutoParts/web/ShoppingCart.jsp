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
                    
                    <table>
                        <tr>
                            <td>Department</td>
                            <td>Part Name</td>
                            <td>Description</td>
                            <td>Quantity</td>
                            <td>Unit Price</td>
                            <td>Total Price</td>
                        </tr>
                        <jsp:useBean id="cart" scope="session" class="autopartstore.ShoppingCart" />
                        <c:if test="${cart.lineItemCount==0}">
                            <tr>
                                <td>Cart is currently empty!</td>
                            </tr>
                        </c:if>
                        <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
                            <form action="ShoppingCartServlet" method="POST" name="item">
                                <tr>
                                    <td><c:out value="${cartItem.dept}" /><br /><c:out value="${cartItem.partName}" /></td>
                                    <td>
                                        <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}" />'>
                                        <input type='text' name='quantity' value='<c:out value="${cartItem.quantity}"/>'>
                                        <input type="submit" name="action" value="Update"><br />
                                        <input type="submit" name="action" value="Delete"
                                    </td>
                                    <td>$<c:out value="${cartItem.unitPrice}"/></td>
                                    <td>$<c:out value="${cartItem.totalPrice}"/></td>
                                </tr>
                            </form>
                        </c:forEach>
                                <tr>
                                    <td> </td>
                                    <td> </td>
                                    <td>Subtotal: $<c:out value="${cart.orderTotal}"/></td>
                                </tr>
                    </table>
                    
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
    </body>
</html>
