<%-- 
    Document   : updateprofile.jsp
    Created on : Sep 17, 2018, 11:43:48 AM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="headerTemplate.jsp" %>
<%@ include file="loggedInOnly.jsp" %>

<div class='main-container'>

    <div class="row">
        <div class="col-md-3 ">
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#dash" class="list-group-item nav-link" id="list-home-list" data-toggle="tab" role="tab">Dashboard</a></li>
                <li><a href="#user" class="list-group-item nav-link " id="list-user-list" data-toggle="tab"  role="tab">User Management</a></li>
                <li><a href="#orders" class="list-group-item nav-link " id="list-orders-list" data-toggle="tab" role="tab">Orders</a></li>
                <li><a href="#help" class="list-group-item nav-link " id="list-help-list" data-toggle="tab" role="tab">Enquiry</a></li>
            </ul>
        </div>
        <div class="col-md-9">
            <div class="tab-content">
                <div class="tab-pane fade in active" id="dash" role="tabpanel">
                    <div class="">
                        <div class="panel panel-info">
                            <div class="panel-heading text-center"><h3>${customer.getcustName()}'s Overview</h3></div>
                            <div class="panel-body">   

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="user" role="tabpanel">
                    <div class="">
                        <div class="panel panel-info">
                            <div class="panel-heading text-center"><h3>Update my information</h3></div>
                            <div class="panel-body">   
                                <form action="updatecustomer.jsp" method="post">
                                    <div class="form-group">
                                        <c:set var="customerNames" value="${fn:split(customer.getcustName(), ' ')}" />
                                        <label for="confirm" class="cols-sm-2 control-label">First and Last Name</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-user"></span></span>
                                            <input type="text" name="fname" class="form-control w-50" placeholder="First Name" value="${customerNames[0]}"/>
                                            <input type="text" name="lname" class="form-control w-50" placeholder="Last Name" value="${customerNames[1]}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Email</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-envelope"></span></span>
                                            <input type="text" name="email" class="form-control" placeholder="Email" value="${customer.getemail()}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">New Password</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-lock"></span></span>
                                            <input type="password" name="pass"class="form-control" placeholder="New Password" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Address</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-home"></span></span>
                                            <input type="text" name="addr_street" class="form-control w-50" placeholder="Street" value="${customerNames[0]}"/>
                                            <input type="text" name="addr_city" class="form-control w-25" placeholder="City" value="${customerNames[0]}"/>
                                            <input type="text" name="addr_state" class="form-control w-10" placeholder="State" value="${customerNames[1]}"/>
                                            <input type="text" name="addr_zip" class="form-control w-15" placeholder="Zipcode" value="${customerNames[1]}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Username</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-heart"></span></span>
                                            <input type="text" name="username" class="form-control" placeholder="Username" value="${customer.getusername()}" disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Credit Card</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="fa fa-credit-card"></span></span>
                                            <input type="text" name="creditc" class="form-control" placeholder="Credit card" value="${customer.getcreditC()}"/>
                                        </div>
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="update">
                                        Save
                                    </button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="orders" role="tabpanel">
                    <div class="panel panel-info">
                        <div class="panel-heading text-center"><h3>Order History</h3></div>
                        <div class="panel-body">   
                            <c:if test="${orders != null}">
                                <c:forEach items="${orders}" var="order">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Order #${order.getID()} placed on ${order.getDate()}</h3>
                                        </div>
                                        <div class="panel-body">
                                            <c:if test="${admin}">
                                                <div class="form-group">
                                                    <form action="updateOrderServlet" method="post" class="form-inline">
                                                        <div class="form-group">
                                                            <input type="hidden" name="orderID" value="${order.getID()}">
                                                            <label class="control-label">Change Order Status:</label>
                                                            <select class="form-control" name="orderStatus" onchange="this.form.submit()">
                                                                <option value="0" <c:if test="${order.getStatus() ==0}">selected</c:if>>Invoiced</option>
                                                                <option value="1" <c:if test="${order.getStatus() ==1}">selected</c:if>>Shipping</option>
                                                                <option value="2" <c:if test="${order.getStatus() ==2}">selected</c:if>>Out for Delivery</option>
                                                                <option value="3" <c:if test="${order.getStatus() ==3}">selected</c:if>>Delivered</option>
                                                                </select>
                                                            </div>
                                                            <button type="submit" name="action" value="Delete" class="btn btn-danger pull-right">Delete</button>
                                                        </form>
                                                    </div>
                                            </c:if>
                                            <c:if test="${!admin}">
                                                <div class="row">
                                                    <div class="board">
                                                        <ul class="nav nav-tabs">
                                                            <div class="liner"></div>
                                                            <li rel-index="0" class="col-md-2 col-xs-2 hidden-xs <c:if test="${order.getStatus() ==0}">active</c:if>">
                                                                    <a href="#step-1">
                                                                        <span><i class="fas fa-file-invoice-dollar"></i></span>
                                                                    </a>
                                                                </li>
                                                                <li rel-index="1" class="col-md-2 col-xs-2 hidden-xs <c:if test="${order.getStatus() ==1}">active</c:if>">
                                                                    <a href="#step-2">
                                                                        <span><i class="fa fa-truck-loading"></i></span>
                                                                    </a>
                                                                </li>
                                                                <li class="col-md-4 col-sm-4 col-xs-12" style="white-space: nowrap;">
                                                                    <a href="#step-5" class="visible-xs">
                                                                        <span></span>
                                                                    </a>
                                                                    <h2 style="margin: 0 0 20px 0;text-align: center;">${order.getStringStatus()}</h2>
                                                            </li>
                                                            <li rel-index="2" class="col-md-2 col-xs-2 hidden-xs <c:if test="${order.getStatus() ==2}">active</c:if>">
                                                                    <a href="#step-3">
                                                                        <span><i class="fa fa-truck"></i></span>
                                                                    </a>
                                                                </li>
                                                                <li rel-index="3" class="col-md-2 col-xs-2 hidden-xs <c:if test="${order.getStatus() ==3}">active</c:if>">
                                                                    <a href="#step-4">
                                                                        <span><i class="fa fa-home"></i></span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                            </c:if>
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
                                </c:forEach>
                            </c:if>

                        </div>
                    </div>

                </div>
                <div class="tab-pane" id="help" role="tabpanel">
                    <div class="">
                        <div class="panel panel-info">
                            <div class="panel-heading text-center"><h3>Call Customer Support</h3></div>
                            <div class="panel-body">   

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%@ include file="footerTemplate.jsp" %>