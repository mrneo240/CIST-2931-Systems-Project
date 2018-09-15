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
                                <c:set var="requestPage" value="${fn:split(pageContext.request.requestURI, '/')}" />
                                <li class="${requestPage[1].equals('index.jsp') ? 'active' : ''}"><a href="index.jsp">Home ${requestPage[1].equals('index.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                                <li class="${requestPage[1].equals('exterior.jsp') ? 'active' : ''}"><a href="exterior.jsp">Exterior${requestPage[1].equals('exterior.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                                <li class="${requestPage[1].equals('interior.jsp') ? 'active' : ''}"><a href="interior.jsp">Interior${requestPage[1].equals('interior.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                                <li class="${requestPage[1].equals('faq.jsp') ? 'active' : ''}"><a href="faq.jsp">FAQ${requestPage[1].equals('faq.jsp') ? '<span class="sr-only">(current)</span>' : ''}</a></li>
                            </ul>
                            <div class='form-group'> 
                            </div>
                            <form class="navbar-form navbar-left pull-right" action="searchItemServlet" method="post">
                                <div class="form-group">
                                <c:if test="${loginID == null}">
                                    <a href="#" data-toggle="modal" class='login-btn btn btn-primary' data-target="#login-modal">Login</a>
                                </c:if>
                                <c:if test="${loginID != null}">
                                    <a href="#" data-toggle="modal" class='logout-btn btn btn-primary' data-target="#logout-modal">Logout</a>
                                </c:if>
                                <input type="text" class="form-control" name="searchTerm" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-primary submit-btn">Submit</button>
                        </form>

                    </div>
                </div>
            </nav>