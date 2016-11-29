<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--todo delete needless comments-->

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customers</title>
</head>
<body>


<c:url var="addUrl" value="/customers/add"/>
<section class="container">
    <div class="row">
        <c:forEach items="${customers}" var="customer">
            <c:url var="editUrl" value="/customers/edit?id=${customer.customerId}" />
            <c:url var="deleteUrl" value="/customers/delete?id=${customer.customerId}" />

            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Name: ${customer.name}</h3>
                        <p>Address:</p>
                        <p> ${customer.billingAddress.streetName} ${customer.billingAddress.doorNo},</p>
                        <p>${customer.billingAddress.regionName},</p>
                        <p>${customer.billingAddress.state},</p>
                        <p>${customer.billingAddress.country}</p>
                        <p>${customer.billingAddress.zipCode}</p>
                        <br>
                        <p>Phone number: ${customer.phoneNumber}</p>
                        <p>E-mail: ${customer.email}</p>

                        <p><a href="${editUrl}">Edit</a></p>
                        <p><a href="${deleteUrl}">Delete</a></p>
                        <p><a href="${addUrl}">Add</a></p>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <c:if test="${empty customers}">
        There are no customers in your shop. Do you wanna be a first one?<br>
        <a href="${addUrl}">Add</a>
    </c:if>
</section>
</body>
</html>