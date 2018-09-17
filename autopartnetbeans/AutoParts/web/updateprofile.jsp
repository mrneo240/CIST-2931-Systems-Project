<%-- 
    Document   : updateprofile.jsp
    Created on : Sep 17, 2018, 11:43:48 AM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>
<%@ include file="WEB-INF/loggedInOnly.jsp" %>
 
<div class='main-container'>

    <div class="row">
        <div class="col-md-3 ">
            <div class="list-group" id="profileList" role="tablist">
                <a href="#dash" class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" role="tab">Dashboard</a>
                <a href="#user" class="list-group-item list-group-item-action" id="list-user-list" data-toggle="list"  role="tab" >User Management</a>
                <a href="#orders" class="list-group-item list-group-item-action" id="list-orders-list" data-toggle="list"  role="tab">Orders</a>
                <a href="#help" class="list-group-item list-group-item-action" id="list-help-list" data-toggle="list" role="tab">Enquiry</a>
            </div> 
        </div>
        <div class="col-8">
            <div class="tab-content">
                <div class="tab-pane active" id="dash" role="tabpanel">
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

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span>
                                        </span>
                                        <input type="text" class="form-control" placeholder="First Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" class="form-control" placeholder="Last Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                        <input type="text" class="form-control" placeholder="Email" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" class="form-control" placeholder="New Password" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
                                        <input type="text" class="form-control" placeholder="Address" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-heart"></span></span>
                                        <input type="text" class="form-control" placeholder="Username" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></span>
                                        <input type="text" class="form-control" placeholder="Credit card" />
                                    </div>
                                </div>
                                <button class="btn btn-lg btn-primary btn-block" type="submit">
                                    Save
                                </button>


                            </div>
                        </div>
                    </div><!--
                                   <div class="col-md-9">
                                   <div class="card">
                                       <div class="card-body">
                                           <div class="row">
                                               <div class="col-md-12">
                                                   <h4>Your Profile</h4>
                                                   <hr>
                                               </div>
                                           </div>
                                           <div class="row">
                                               <div class="col-md-12">
                                                   <form>
                                             <div class="form-group row">
                                               <label for="username" class="col-4 col-form-label">User Name*</label> 
                                               <div class="col-8">
                                                 <input id="username" name="username" placeholder="Username" class="form-control here" required="required" type="text">
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="name" class="col-4 col-form-label">First Name</label> 
                                               <div class="col-8">
                                                 <input id="name" name="name" placeholder="First Name" class="form-control here" type="text">
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="lastname" class="col-4 col-form-label">Last Name</label> 
                                               <div class="col-8">
                                                 <input id="lastname" name="lastname" placeholder="Last Name" class="form-control here" type="text">
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="select" class="col-4 col-form-label">Display Name public as</label> 
                                               <div class="col-8">
                                                 <select id="select" name="select" class="custom-select">
                                                   <option value="admin">Admin</option>
                                                 </select>
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="email" class="col-4 col-form-label">Email*</label> 
                                               <div class="col-8">
                                                 <input id="email" name="email" placeholder="Email" class="form-control here" required="required" type="text">
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="publicinfo" class="col-4 col-form-label">Public Info</label> 
                                               <div class="col-8">
                                                 <textarea id="publicinfo" name="publicinfo" cols="40" rows="4" class="form-control"></textarea>
                                               </div>
                                             </div>
                                             <div class="form-group row">
                                               <label for="newpass" class="col-4 col-form-label">New Password</label> 
                                               <div class="col-8">
                                                 <input id="newpass" name="newpass" placeholder="New Password" class="form-control here" type="text">
                                               </div>
                                             </div> 
                                             <div class="form-group row">
                                               <div class="offset-4 col-8">
                                                 <button name="submit" type="submit" class="btn btn-primary">Update My Profile</button>
                                               </div>
                                             </div>
                                           </form>
                                               </div>
                                           </div>
             
                                       </div>
                                   </div>
                               </div>--></div>
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
<%@ include file="WEB-INF/footerTemplate.jsp" %>
</body>
</html>