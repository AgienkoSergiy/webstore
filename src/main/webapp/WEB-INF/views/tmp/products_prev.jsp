<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html>

<c:url var="addUrl" value="/products/add"/>

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
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
        </c:forEach>
    </div>
    <c:if test="${empty products}">
    There are no products in your shop. Do you wanna add first one?<br>
    <a href="${addUrl}">Add</a>
</c:if>
</section>

</html>