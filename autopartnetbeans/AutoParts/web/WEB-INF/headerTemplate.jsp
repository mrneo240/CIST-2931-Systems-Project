<%-- 
    Document   : headerTemplate
    Created on : Sep 15, 2018, 11:49:42 AM
    Author     : Hayden Kowalchuk
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" href="./css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="./css/font-awesome.min.css">

        <link rel="stylesheet" href="./css/custom.css" />
        <c:if test="${notFoundPage}">
            <link rel="stylesheet" href="./css/error.css" />
        </c:if>
        <c:if test="${errorPage}">
            <link rel="stylesheet" href="./css/exception.css" />
        </c:if>
        <title>System Project</title>
    </head>
    <body class='container'>
        <div class='wrapper'>
            <nav class="navbar navbar-default ">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <img src="img/brand.png" alt="auto parts image" width="180x" height="60"/>
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div>
                        <ul class="nav navbar-nav">
                            <c:set var="requestPageArr" value="${fn:split(pageContext.request.requestURI, '/')}" />
                            <c:set var="requestPage" value="${requestPageArr[fn:length(requestPageArr)-1]}" />
                            <li class="${requestPage.equals('index.jsp') ? 'active' : ''}"><a href="index.jsp">Home ${requestPage.equals('index.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                            <li class="${requestPage.equals('displaydept.jsp') ? 'active' : ''}"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Department<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li class="${searchTerm.equals('All') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=All">All</a></li>
                                    <li class="${searchTerm.equals('Exterior') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=exterior">Exterior</a></li>
                                    <li class="${searchTerm.equals('Interior') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=interior">Interior</a></li>
                                    <li class="${searchTerm.equals('Engine') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=engine">Engine</a></li>
                                    <li class="${searchTerm.equals('Maintenance') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=maintenance">Maintenance</a></li>
                                </ul>
                            </li>
                            <li class="${requestPage.equals('faq.jsp') ? 'active' : ''}"><a href="faq.jsp">FAQ${requestPage.equals('faq.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                                <c:if test="${loginID == null}">
                                <li><a a href="#" data-toggle="modal" data-target="#login-modal">Login</a></li>
                                </c:if>    
                                <c:if test="${loginID != null}">
                                <li class="${requestPage.equals('updateprofile.jsp') ? 'active' : ''}"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Account<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a a href="#" data-toggle="modal" data-target="#logout-modal">Logout</a></li>
                                        <li class="${requestPage.equals('updateprofile.jsp') ? 'active' : ''}"><a href="updatecustomer.jsp">Manage Account</a></li>
                                    </ul></li>
                                </c:if>
                        </ul>

                        <form class="navbar-form pull-right" role="search" action="searchItemServlet" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search..." name="searchTerm">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                            <a class="btn btn-success btn-sm ml-3" href="ShoppingCart.jsp">
                                <i class="fa fa-shopping-cart fa-lg"></i> Cart
                                <span class="badge badge-light">${cart.getLineItemCount()>0? cart.getLineItemCount():""}</span>
                            </a>
                        </form>
                    </div>
                </div>
                <div class="container"><c:if test="${loginID != null}"><p class="font-weight-bold">Hello ${customer.getcustName()}</p></c:if></div>
                </nav>
            <c:if test="${displayAlert}">
                <div class="alert ${alertType} alert-dismissable" role="alert"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${alertMessage}</div>
                <c:remove var = "alertType"/>
                <c:remove var = "displayAlert"/>
                <c:remove var = "alertMessage"/>
            </c:if>