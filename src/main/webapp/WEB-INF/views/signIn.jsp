
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<section class="container">
    <form:form modelAttribute="newCustomer" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
            <legend>Fill the fields</legend>
            <div class="container">
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">
                        <spring:message code="addCustomer.form.name.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                        <form:errors path="name" cssClass="text-danger"/>
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
                    <label class="control-label col-lg-2 col-lg-2" for="email">
                        <spring:message code="addCustomer.form.password.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="email" path="password" type="password" class="form:input-large"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="email">
                        <spring:message code="addCustomer.form.confirmPassword.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="email" path="matchingPassword" type="password" class="form:input-large"/>
                        <form:errors path="matchingPassword" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class=
                                "btn btn-primary" value ="Add"/>
                    </div>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>