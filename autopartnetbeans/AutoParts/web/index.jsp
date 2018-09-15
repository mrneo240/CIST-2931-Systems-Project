<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/custom.css" />
        <title>System Project</title>
    </head>

    <body class='container'>
        <div class='wrapper'>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">AutoParts Logo</a>
                        <c:if test="${loginID != null}"><p class="font-weight-bold">Hello ${customer.getcustName()}</p></c:if>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
                                <li><a href="exterior.jsp">Exterior</a></li>
                                <li><a href="interior.jsp">Interior</a></li>
                                <li class=""><a href="faq.jsp">FAQ</a></li>
                            </ul>
                            <div class='form-group'> 
                            </div>
                            <form class="navbar-form navbar-left pull-right">
                                <div class="form-group">
                                <c:if test="${loginID == null}">
                                    <a href="#" data-toggle="modal" class='login-btn btn btn-primary' data-target="#login-modal">Login</a>
                                </c:if>
                                <c:if test="${loginID != null}">
                                    <a href="#" data-toggle="modal" class='logout-btn btn btn-primary' data-target="#logout-modal">Logout</a>
                                </c:if>
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-primary submit-btn">Submit</button>
                        </form>

                    </div>
                </div>
            </nav>
            <div class='main-container'>

                <div id="slideshow-wrapper" class='relative'>
                    <div class='search-form col-xs-5'>
                        <h2>Search for parts</h2>
                        <form class="form-horizontal" action="/action_page.php">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="customerID" placeholder="Customer ID#">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="part" placeholder="Search for parts">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary submit-btn">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="slideshow">
                        <img src="https://images.pexels.com/photos/924675/pexels-photo-924675.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"></img>
                        <img src="https://images.pexels.com/photos/159275/macro-focus-cogwheel-gear-159275.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></img>
                        <img src="https://images.pexels.com/photos/191738/pexels-photo-191738.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></img>
                    </div>
                    <div style="text-align: center">
                        <div id="circle1" class="circle"></div>
                        <div id="circle2" class="circle"></div>
                        <div id="circle3" class="circle"></div>
                    </div>
                </div>

            </div>

            <hr/>
            <div class="row text-center feature-imgs">
                <h2>Feature Items</h2>
                <div class="col-sm-4">
                    <div class="thumbnail">
                        <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png" alt="Paris">
                        <p><strong>Full Synthetic Oil</strong></p>
                        <button class="btn">Add to cart</button>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="thumbnail">
                        <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg" alt="New York">
                        <p><strong>Alternator</strong></p>
                        <button class="btn">Add to cart</button>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="thumbnail">
                        <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg" alt="San Francisco">
                        <p><strong>Pulley</strong></p>
                        <button class="btn">Add to cart</button>
                    </div>
                </div>
            </div>


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
    </body>

</html>