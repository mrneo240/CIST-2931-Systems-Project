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
            <p style="
               white-space: nowrap;
               overflow: hidden;
               text-overflow: ellipsis;
               display: inline-block;
               padding: 10px;">Copyright @2017 | Express Car Parts</p>
            <a href="legalPolicies.jsp#Terms-and-conditions" style="right: 100px;">Terms &amp; Conditions</a>
            <a href="legalPolicies.jsp#Privacy-policy" style="right: 0px;">Privacy Policy</a>
        </div>
    </div>
</div>

<div class="modal fade" id="login-modal" role="dialog" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Login</h1><br>
            <form action="login.jsp" method="post">
                <input type="text" name="user" placeholder="Username">
                <input type="password" name="pass" placeholder="Password">
                <input type="submit" name="action" class="login loginmodal-submit" value="login">
            </form>    
            <div class="login-help">
                <a href="#" data-toggle="modal" data-target="#register-modal" data-dismiss="modal">Register</a>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="logout-modal" role="dialog" style="display: none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
            <div class="modal-body"><i class="fa fa-question-circle"></i> Are you sure you want to log-off?</div>
            <div class="modal-footer">
                <form action="login.jsp" method="post"><button type="submit" name="action" class="login logoutmodal-submit btn btn-danger" value="logout">Logout</button></form>         
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
                            <input type="text" name="addr_street" class="form-control w-50" placeholder="Street" value="${customerNames[0]}"/>
                            <input type="text" name="addr_city" class="form-control w-25" placeholder="City" value="${customerNames[0]}"/>
                            <input type="text" name="addr_state" class="form-control w-10" placeholder="State" value="${customerNames[1]}"/>
                            <input type="text" name="addr_zip" class="form-control w-15" placeholder="Zipcode" value="${customerNames[1]}"/>
                        </div>
                    </div>
                    <div class="form-group ">
                        <button class="btn btn-primary btn-lg btn-block login-button" type="submit" name="action" class="login logoutmodal-submit" value="register">Register</button>
                    </div>
                    <div class="login-register">
                        <a href="#" data-toggle="modal"  data-target="#login-modal" data-dismiss="modal">Login</a>
                    </div>
                </form>
            </div>
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