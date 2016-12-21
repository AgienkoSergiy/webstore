<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Web Store Homepage</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-music"/></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:forEach items="${categories}" var="category">
                    <li>
                        <a href="<spring:url value="/products/${category.restKey}"/>">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
            <div class="login-wrapper">
                <sec:authorize access="isAnonymous()">
                    <a href="<spring:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Log in</a>
                    <a href="<spring:url value="/signIn"/>">Sign in</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a href="<spring:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> Log out</a>
                </sec:authorize>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <p class="lead">Raisin Web Store logo big</p>
        <br><br><br><br><br><br>

        <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="http://placehold.it/800x300" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="http://placehold.it/800x300" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="http://placehold.it/800x300" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>

        <h2 class="lead">Best Sellers</h2>
        <section id="bestsellers">
            <c:forEach items="${bestsellers}" var="entry" varStatus="rowCounter">
                <c:if test="${rowCounter.count % 3 == 1|| rowCounter.count==1}">
                    <div class="row">
                </c:if>
                <div class="col-sm-4 col-md-4 col-lg-4"  style="padding-bottom:15px">
                    <h3 class="lead">${entry.key}</h3>
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/images/${entry.value.productId}.jpg"/>"
                             alt="image" style = "width:100%"/>
                        <div class="caption">
                            <h3>${entry.value.manufacturer} ${entry.value.name}</h3>
                            <p>$${entry.value.unitPrice}</p>
                            <p>
                                <a href=" <spring:url value="/products/product?id=${entry.value.productId}" /> "
                                   class="btn btn-primary">
                                    <span class="glyphicon-info-sign glyphicon">Details</span>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
                <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(bestsellers)}">
                    </div>
                </c:if>
            </c:forEach >
        </section>

    </div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <p>If you like this template, then check out <a target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this tutorial</a> on how to build a working review system for your online store!</p>
            <a class="btn btn-primary" target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View Tutorial</a>

            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>
