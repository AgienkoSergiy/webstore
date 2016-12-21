<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>

<section>
        <div class="pull-right" style="padding-right:50px">
            <a href="product?id=${product.productId}&language=en" >English</a>|
            <a href="product?id=${product.productId}&language=nl">Dutch</a>
        </div>
        <div class="container">
            <h1>Products</h1>
        </div>
</section>
<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url  value="/resources/images/${product.productId}.jpg"> </c:url>"
                 alt="image" style = "width:100%"/>
        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong><spring:message code="product.productId"/> : </strong>
                <span class="label label-warning">${product.productId}</span>
            </p>
            <p>
                <strong><spring:message code="product.manufacturer"/> </strong> :
                 ${product.manufacturer}
            </p>
            <p>
                <strong><spring:message code="product.category"/> </strong> :
                 ${product.category.name}
            </p>
            <p>
                <strong><spring:message code="product.unitsInStock"/> </strong> :
                ${product.unitsInStock}
            </p>
            <h4>${product.unitPrice} USD</h4>
            <p ng-controller="cartCtrl">
                <a href="<spring:url value="/products" />" class="btn btndefault">
                    <span class="glyphicon-hand-left glyphicon"> </span>
                    <spring:message code="back"/>
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span>
                    View Cart
                </a>
                <a href="#" class="btn btn-warning btn-small"
                   ng-click="addToCart('${product.productId}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    <spring:message code="product.orderNow"/>
                </a>
            </p>
            <p>
                <a href="<spring:url value="/resources/pdf/${product.productId}.pdf" />"
                   target="_blank" class="btn btndefault">
                    <span class="glyphicon glyphicon-eye-open"></span>
                    <spring:message code="product.viewManual"/>
                </a>
            </p>
        </div>
    </div>
</section>
