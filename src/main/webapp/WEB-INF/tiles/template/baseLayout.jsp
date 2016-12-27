<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><tiles:insertAttribute name="title" /></title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>

<body>

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
            <a class="navbar-brand" href="<spring:url value="/"/>"><span class="glyphicon glyphicon-music"></span></a>
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



<div class="container">

    <div class="row">
        <tiles:insertAttribute name="content" />
    </div>

    <div class="footer">
        <tiles:insertAttribute name="footer" />
    </div>

</div>
</body>
</html>
