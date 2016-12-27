<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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
                        <div class="img-wrapper">
                            <span class="helper"></span>
                            <img src="<c:url value="/resources/images/${entry.value.productId}.jpg"/>"
                                 alt="image"/>
                        </div>
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


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

