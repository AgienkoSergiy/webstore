<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>



</head>
<body>

<section class="container" ng-app="cartApp" style="height:100vh;">
    <br><br><br><br><br><br><br>
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
        <div>
            <a class="btn btn-danger pull-left" ng-click="clearCart()">
                <span class="glyphicon glyphicon-remove-sign"></span>
                Clear Cart
            </a>
            <a href="<spring:url value="/checkout?cartId=${cartId}"/>"
                    class="btn btn-success pull-right">
            <span class="glyphicon-shopping-cart glyphicon"></span>
            Check out
        </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit price</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <%--<tr ng-repeat="item in cart.cartItems">  TODO hotfix cart issue#1 --%>
                <%--<td>{{item.product.productId}}-{{item.product.name}}</td>--%>
                <%--<td>{{item.product.unitPrice}}</td>--%>
                <%--<td>{{item.quantity}}</td>--%>
                <%--<td>{{item.totalPrice}}</td>--%>
                <%--<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">--%>
                    <%--<span class="glyphicon glyphicon-remove"></span> Remove--%>
                <%--</a></td>--%>
            <%--</tr>--%>
            <c:forEach items="${cart.cartItems}" var="cartItem">
                <tr>
                    <td>${cartItem.key.manufacturer} ${cartItem.key.name}</td>
                    <td>${cartItem.key.unitPrice}</td>
                    <td>${cartItem.value.quantity}</td>
                    <td>${cartItem.value.totalPrice}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span> Remove
                    </a></td>
                </tr>
            </c:forEach>
            <tr>
                <th></th>
                <th></th>
                <th>Grand Total</th>
                <th>${cart.grandTotal}</th>
                <th></th>
            </tr>
        </table>

        <a href="<spring:url value="/products" />" class="btn btndefault">
            <span class="glyphicon-hand-left glyphicon"></span>
            Continue shopping
        </a>
    </div>
</section>
</body>
</html>
