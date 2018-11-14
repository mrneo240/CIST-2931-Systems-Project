<%-- 
    Document   : footerTemplate
    Created on : Sep 15, 2018, 11:53:59 AM
    Author     : Hayden Kowalchuk
    Edited     : Michelle (Boobin) Choi
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<div class="footer">
    <div class="footer-content">
        <div style="position: relative;">
            <p>Copyright @2017 | Express Car Parts</p>
            <a href="legalPolicies.jsp#Terms-and-conditions" style="right: 100px;">Terms &amp; Conditions</a>
            <a href="legalPolicies.jsp#Privacy-policy" style="right: 0px;">Privacy Policy</a>
        </div>
    </div>
</div>
<div class="modal fade" id="lookup-modal" role="dialog" style="display: none;">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="title">Lookup Order</h1>
            </div> 
            <div class="main-center">
                <form class="form-horizontal" method="post" action="lookup.jsp">
                    <div class="form-group">
                        <label for="order" class="cols-sm-2 control-label">Order ID</label>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fas fa-barcode" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="order" id="order"  placeholder="Order ID"/>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="submit" name="action" style="float:right;" class="btn btn-primary btn-lg" value="login">Go</button>
            </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="login-modal" role="dialog" style="display: none;">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="title">Login</h1>
            </div> 
            <div class="main-center">
                <form class="form-horizontal" method="post" action="login.jsp">
                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Username</label>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="user" id="user"  placeholder="Enter your Username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="pass" id="pass"  placeholder="Enter your Password"/>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="submit" name="action" style="float:right;" class="btn btn-primary btn-lg" value="login">Login</button>
                <button href="#" data-toggle="modal" style="float:left;" class="btn btn-warning btn-lg" data-target="#register-modal" data-dismiss="modal">Register</button>
            </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="logout-modal" role="dialog" style="display: none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="title">Logout &nbsp;<i class="fa fa-lock"></i></h1>
            </div> 
            <div class="logout-center">
                <i class="fa fa-question-circle"></i> Are you sure you want to logout?
            </div>
            <div class="modal-footer">
                <form action="login.jsp" method="post"><button type="submit" name="action" class="btn btn-lg btn-danger" value="logout">Logout</button></form>         
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="register-modal" tabindex="-1" role="dialog" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="title">Registration</h1>
            </div> 
            <div class="main-login main-center">
                <form class="form-horizontal" method="post" action="createNewSignup.jsp">

                    <div class="form-group">
                        <label for="name" class="cols-med-2 control-label">Your Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Your Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Address</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-home"></span></span>
                            <input type="text" name="addr_street" class="form-control w-50" placeholder="Street" />
                            <input type="text" name="addr_city" class="form-control w-25" placeholder="City" />
                            <input type="text" name="addr_state" class="form-control w-10" placeholder="State" />
                            <input type="text" name="addr_zip" class="form-control w-15" placeholder="Zipcode" />
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button style="float:right;" class="btn btn-primary btn-lg col-sm-8" type="submit" name="action" value="register">Register</button>
                <button href="#" data-toggle="modal" style="float:left;" class="btn btn-warning btn login-button col-sm-2 btn-lg" data-target="#login-modal" data-dismiss="modal">Login</button>
            </div>
            </form>
        </div>
    </div>
</div>
</div>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/slide.js"></script>
<c:if test="${jsScript != null}">
    <script>
        $(function () {
        ${jsScript}
        });
    </script>
    <c:remove var="jsScript" />
</c:if>
</body>
</html>