<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/carousel/">
    <title>E-Music Store</title>

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/static/css/bootstrap.min.css"/> " rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="<c:url value="/resources/static/css/carousel.css"/> " rel="stylesheet">
    <!-- Main CSS -->
    <link href="<c:url value="/resources/static/css/main.css"/> " rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">E-Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/"/> ">Home</a></li>
                        <li><a href="<c:url value="/product/productList"/> ">Products</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <!-- login check -->
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/logout" />">Logout</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li><a href="<c:url value="/customer/cart"/>">Cart</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin"/>">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="<c:url value="/login"/>">login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a> </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>