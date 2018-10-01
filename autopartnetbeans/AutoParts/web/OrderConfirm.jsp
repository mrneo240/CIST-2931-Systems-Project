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
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                    <li class=""><a href="ShoppingCart.jsp">
                            <h4 class="list-group-item-heading">Step 1</h4>
                            <p class="list-group-item-text">Shopping Cart</p>
                        </a></li>
                    <li class="active"><a href="OrderConfirm.jsp">
                            <h4 class="list-group-item-heading">Step 2</h4>
                            <p class="list-group-item-text">Delivery and Payment Details</p>
                        </a></li>
                    <li class="disabled"><a href="" onclick="javascript:return false">
                            <h4 class="list-group-item-heading">Step 3</h4>
                            <p class="list-group-item-text">Order Confirmation</p>
                        </a></li>
                </ul>
            </div>
            <div class="row cart-body">
                <form class="form-horizontal" method="post" action="orderCheckoutServlet">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                        <!--REVIEW ORDER-->
                        <div class="panel panel-default">
                            <div class="panel-heading text-center">
                                <h4>Review Order <div class="pull-right"><small><a class="afix-1" href="ShoppingCart.jsp">Edit Cart</a></small></div></h4>
                            </div>
                            <div class="panel-body panel-cart">
                                <c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter">
                                    <div class="form-group">
                                        <div class="col-sm-3 col-xs-3">
                                            <img class="img-responsive" src="https://loremflickr.com/320/240/${cartItem.getDept()}?id=${cartItem.getPrice()}" />
                                        </div>
                                        <div class="col-sm-6 col-xs-6">
                                            <div class="col-xs-12">${cartItem.getName()}</div>
                                            <div class="col-xs-12"><small>Quantity:<span>${cartItem.getQuantity()}</span></small></div>
                                        </div>
                                        <div class="col-sm-3 col-xs-3 text-right">
                                            <h6><span>$</span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.getTotalPrice()}"/></h6>
                                        </div>
                                    </div>
                                    <div class="form-group"><hr /></div>
                                    </c:forEach>

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <strong>Subtotal</strong>
                                        <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderSubTotal()}"/></span></div>
                                    </div>
                                    <div class="col-xs-12">
                                        <small>Tax</small>
                                        <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTax()}"/></span></div>
                                    </div>
                                    <div class="col-xs-12">
                                        <small>Shipping</small>
                                        <div class="pull-right"><span>-</span></div>
                                    </div>
                                </div>
                                <div class="form-group"><hr /></div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <strong>Order Total</strong>
                                        <div class="pull-right"><span>$</span><span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cart.getOrderTotal()}"/></span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--REVIEW ORDER END-->
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
                        <!--SHIPPING METHOD-->
                        <div class="panel panel-default">
                            <div class="panel-heading text-center"><H4>Address</H4></div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <h4>Shipping Address</h4>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12"><strong>Country:</strong></div>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" name="country" value="USA" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12 col-xs-12">
                                        <strong>Name:</strong>
                                        <input type="text" name="first_name" class="form-control" value="${customer.getcustName()}" />
                                    </div>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-12"><strong>Address:</strong></div>
                                    <div class="col-md-12">
                                        <input type="text" name="address" class="form-control" value="${customer.getaddress()}" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-6 col-xs-12">
                                        <strong>City:</strong>
                                        <input type="text" name="city" class="form-control" value="" />
                                    </div>
                                    <div class="span1"></div>
                                    <div class="col-md-3 col-xs-6">
                                        <strong>State:</strong>
                                        <input type="text" name="state" class="form-control" value="" />
                                    </div>
                                    <div class="span1"></div>
                                    <div class="col-md-3 col-xs-6">
                                        <strong>Zip Code:</strong>
                                        <input type="text" name="zip_code" class="form-control" value="" />
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-12"><strong>Phone Number:</strong></div>
                                    <div class="col-md-12"><input type="text" name="phone_number" class="form-control" value="" /></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12"><strong>Email Address:</strong></div>
                                    <div class="col-md-12"><input type="text" name="email_address" class="form-control" value="${customer.getemail()}" /></div>
                                </div>
                            </div>
                        </div>
                        <!--SHIPPING METHOD END-->
                        <!--CREDIT CART PAYMENT-->
                        <div class="panel panel-info">
                            <div class="panel-heading text-center"><H4><span><i class="fa fa-lock fa-lg"></i></span> Secure Payment</div></H4>
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-md-12"><strong>Card Type:</strong></div>
                                    <div class="col-md-12">
                                        <select id="CreditCardType" name="CreditCardType" class="form-control">
                                            <option value="5">Visa</option>
                                            <option value="6">MasterCard</option>
                                            <option value="7">American Express</option>
                                            <option value="8">Discover</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9">
                                        <strong>Credit Card Number:</strong>
                                        <input type="text" class="form-control" name="car_number" value="${customer.getcreditC()}" /></div>
                                    <div class="col-md-3"><strong>Card CVV:</strong>
                                        <input type="text" class="form-control" name="car_code" value="" /></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <strong>Expiration Date</strong>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" name="">
                                            <option value="">Month</option>
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" name="">
                                            <option value="">Year</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                            <option value="2021">2021</option>
                                            <option value="2022">2022</option>
                                            <option value="2023">2023</option>
                                            <option value="2024">2024</option>
                                            <option value="2025">2025</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <span>Pay secure using your credit card.</span>
                                    </div>
                                    <div class="col-md-12">
                                        <ul class="cards">
                                            <li class="visa hand">Visa</li>
                                            <li class="mastercard hand">MasterCard</li>
                                            <li class="amex hand">Amex</li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-submit-fix btn-lg">Place Order</button>
                                    </div>
                                </div>                               
                            </div>
                        </div>
                        <!--CREDIT CART PAYMENT END-->
                    </div>

                </form>
            </div>
            <div class="row cart-footer">

            </div>
        </div>
    </div>
    <%@ include file="WEB-INF/footerTemplate.jsp" %>
