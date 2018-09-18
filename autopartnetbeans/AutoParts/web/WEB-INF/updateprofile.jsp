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
        <div class="col-8">
            <div class="tab-content">
                <div class="tab-pane fade in active" id="dash" role="tabpanel">
                    <div class="col-lg-9">
                        <div class="panel">
                            <h3 class="text-center">${customer.getcustName()}'s Overview</h3>
                            <div class="panel-body">   

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="user" role="tabpanel">
                    <div class="col-lg-9">
                        <div class="panel">

                            <h3 class="text-center">
                                Update my information</h3>

                            <div class="panel-body">   
                                <form action="updatecustomer.jsp" method="post">
                                    <div class="form-group">
                                        <c:set var="customerNames" value="${fn:split(customer.getcustName(), ' ')}" />
                                        <label for="confirm" class="cols-sm-2 control-label">First and Last Name</label>
                                            
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                            <input type="text" name="fname" class="form-control w-50" placeholder="First Name" value="${customerNames[0]}"/>
                                            <input type="text" name="lname" class="form-control w-50" placeholder="Last Name" value="${customerNames[1]}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Email</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                            <input type="text" name="email" class="form-control" placeholder="Email" value="${customer.getemail()}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">New Password</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                            <input type="password" name="pass"class="form-control" placeholder="New Password" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Address</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
                                            <input type="text" name="address" class="form-control" placeholder="Address" value="${customer.getaddress()}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Username</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-heart"></span></span>
                                            <input type="text" name="username" class="form-control" placeholder="Username" value="${customer.getusername()}" disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Credit Card</label>
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></span>
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
                    <div class="col-lg-9">
                        <div class="panel">
                            <h3 class="text-center">Order History</h3>
                            <div class="panel-body">   

                            </div>
                        </div>
                    </div>

                </div>
                <div class="tab-pane" id="help" role="tabpanel">
                    <div class="col-lg-9">
                        <div class="panel">
                            <h3 class="text-center">Call Customer Support</h3>
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
</body>
</html>