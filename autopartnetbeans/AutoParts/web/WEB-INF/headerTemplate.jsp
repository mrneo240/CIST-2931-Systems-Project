<%-- 
    Document   : headerTemplate
    Created on : Sep 15, 2018, 11:49:42 AM
    Author     : Hayden Kowalchuk
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <c:set var="requestPageArr" value="${fn:split(pageContext.request.requestURI, '/')}" />
                            <c:set var="requestPage" value="${requestPageArr[fn:length(requestPageArr)-1]}" />
                            <li class="${requestPage.equals('index.jsp') ? 'active' : ''}"><a href="index.jsp">Home ${requestPage.equals('index.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                            <li class="${requestPage.equals('displaydept.jsp') ? 'active' : ''}"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Department<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li class="${searchTerm.equals('Exterior') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=exterior">Exterior</a></li>
                                    <li class="${searchTerm.equals('Interior') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=interior">Interior</a></li>
                                    <li class="${searchTerm.equals('Engine') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=engine">Engine</a></li>
                                    <li class="${searchTerm.equals('Maintenance') ? 'active' : ''}"><a href="displayDeptItems.jsp?cat=maintenace">Maintenance</a></li>
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
                        <div class='form-group'> 
                        </div>
                        <form class="navbar-form navbar-left pull-right" action="searchItemServlet" method="post">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-shopping-cart"></i></span>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="searchTerm" placeholder="Search">
                                </div>
                                <button type="submit" class="btn btn-primary submit-btn">Submit</button>
                        </form>
                    </div>
                </div>
                <div class="container"><c:if test="${loginID != null}"><p class="font-weight-bold">Hello ${customer.getcustName()}</p></c:if></div>
                </nav>
            <c:if test="${requestScope.displayAlert}">
                <div class="alert ${requestScope.alertType} alert-dismissable" role="alert"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${requestScope.alertMessage}</div>
            </c:if>