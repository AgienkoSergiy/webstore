
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--todo delete needless comments-->

<html>
<head>
    <meta http-equiv="Content-Type" content=
            "text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>TEST</title>
</head>
<body>
<br><br><br><br><br><br><br>
<div class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body" ng-controller="cartCtrl">
                    <%--<c:if test="${not empty error}">--%>
                        <%--<div class="alert alert-danger">--%>
                            <%--<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />--%>
                        <%--</div>--%>
                    <%--</c:if>--%>
                    <form  >
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="User email"
                                       name='username' type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='password'
                                       type="text" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='type'
                                       type="text" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='age'
                                       type="text" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block"
                                   type="submit" ng-click="queryToMatrix()" value="Send">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
