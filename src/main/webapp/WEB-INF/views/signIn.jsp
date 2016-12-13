
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<section>
    <div>
        <a href="<c:url value="/logout"/>"
           class="btn btn-danger btn-mini pull-right">logout</a>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=en">English</a>|<a href="?language=nl">Dutch</a>
        </div>
        <div class="container">
            <h1>Sign in</h1>
        </div>
    </div>
</section>


<section class="container">
    <form:form modelAttribute="newCustomer" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
            <legend>Fill the fields</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    <spring:message code="addCustomer.form.name.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>
            <div class="container">
                <h2><spring:message code="addCustomer.form.address.label"/></h2>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.doorNo">
                        <spring:message code="addCustomer.form.doorNumber.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.doorNo" path="billingAddress.doorNo" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.doorNo" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.streetName">
                        <spring:message code="addCustomer.form.streetName.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.streetName" path="billingAddress.streetName" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.streetName" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.regionName">
                        <spring:message code="addCustomer.form.regionName.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.regionName" path="billingAddress.regionName" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.regionName" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.state">
                        <spring:message code="addCustomer.form.state.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.state" path="billingAddress.state" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.state" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.country">
                        <spring:message code="addCustomer.form.country.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.country" path="billingAddress.country" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.country" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="billingAddress.zipCode">
                        <spring:message code="addCustomer.form.zipCode.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="billingAddress.zipCode" path="billingAddress.zipCode" type="text" class="form:input-large"/>
                        <form:errors path="billingAddress.zipCode" cssClass="text-danger"/>
                    </div>
                </div>

            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="phoneNumber">
                    <spring:message code="addCustomer.form.phoneNumber.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="phoneNumber" path="phoneNumber" type="text" class="form:input-large"/>
                    <form:errors path="phoneNumber" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="email">
                    <spring:message code="addCustomer.form.email.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="email" path="email" type="text" class="form:input-large"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class=
                            "btn btn-primary" value ="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>