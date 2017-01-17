<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>





<!-- Page Content -->
<div class="container">

    <h1 class="text-center">Musical Web Store logo</h1>
    <br><br>

    <c:choose>
        <c:when test="${currentCategory==null}">
            <p class="lead">All products</p>
        </c:when>
        <c:otherwise>
            <p class="lead">${currentCategory}</p>
        </c:otherwise>
    </c:choose>

    <section id="products_list">
        <c:forEach items="${products}" var="product" varStatus="rowCounter">
            <c:if test="${rowCounter.count % 3 == 1|| rowCounter.count==1}">
                <div class="row">
            </c:if>
            <div class="col-sm-4 col-md-4 col-lg-4"  style="padding-bottom:15px">
                <div class="thumbnail">
                    <div class="img-wrapper">
                        <span class="helper"></span>
                        <img src="<c:url value="/resources/images/${product.productId}.jpg"/>"
                             alt="image"/>
                    </div>
                    <div class="caption">
                        <h3>${product.manufacturer} ${product.name}</h3>
                        <p>$${product.unitPrice}</p>
                        <p>Available ${product.unitsInStock} units in stock</p>
                        <p>
                            <a href=" <spring:url value="/products/product?id=${product.productId}" /> "
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon">Details</span>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
            <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(products)}">
                </div>
            </c:if>
        </c:forEach >
    </section>

</div>
<!-- /.container -->


<!-- /.container -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


