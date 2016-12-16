<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
            <a class="navbar-brand" href="#">Logo small</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">


    <p class="lead">Raisin Web Store logo big</p>
    <br><br><br><br><br><br>

    <div class="row">  <%--TODO <ul></ul>?--%>
        <div class="col-md-12" style="margin-bottom: 20px;">
            <c:forEach items="${categories}" var="category">
                <div class="col-md-2 cat-button col-sm-2">
                    <a href="<spring:url value="/products/${category.restKey}"/>">${category.name}</a>
                </div>
            </c:forEach>
        </div>
    </div>

    <c:choose>
        <c:when test="${currentCategory==null}">
            <p class="lead">All products</p>
        </c:when>
        <c:otherwise>
            <p class="lead">${currentCategory}</p>
        </c:otherwise>
    </c:choose>

    <div class="row">
        <c:forEach items="${products}" var="product">
           <%-- <c:forEach begin="1" end="3" varStatus="loop">
                <p>loop:${loop.index}</p>--%>
                <div class="col-sm-6 col-md-3" style="padding-bottom:15px">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/images/${product.productId}.png"/>"
                             alt="image" style = "width:100%"/>
                        <div class="caption">
                            <h3>${product.manufacturer} ${product.name}</h3>
                            <p>$${product.unitPrice}</p>
                            <p>Available ${product.unitsInStock} units in
                                stock</p>
                            <p>
                                <a href=" <spring:url value="/products/product?id=${product.productId}" /> "
                                   class="btn btn-primary">
                                    <span class="glyphicon-info-sign glyphicon">Details</span>
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
           <%-- </c:forEach>--%>
        </c:forEach>
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
