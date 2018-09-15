<%-- 
    Document   : footerTemplate
    Created on : Sep 15, 2018, 11:53:59 AM
    Author     : Hayden Kowalchuk
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<div class="footer">
                <div class='footer-content'>
                    <p>Footer</p>
                </div>
            </div>


            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="loginmodal-container">
                        <h1>Login</h1><br>
                        <form action="loginServlet" method="post">
                            <input type="text" name="user" placeholder="Username">
                            <input type="password" name="pass" placeholder="Password">
                            <input type="submit" name="action" class="login loginmodal-submit" value="login">
                        </form>         
                    </div>
                </div>
            </div>
            <div class="modal fade" id="logout-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
                        <div class="modal-body"><i class="fa fa-question-circle"></i> Are you sure you want to log-off?</div>
                        <div class="modal-footer">
                            <form action="loginServlet" method="post"><input type="submit" name="action" class="login logoutmodal-submit" value="logout"></form>         
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="http://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="./js/slide.js"></script>