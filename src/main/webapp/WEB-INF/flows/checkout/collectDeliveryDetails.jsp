<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Delivery</h1>
				<p>Delivery details</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="order.deliveryInfo" class="form-horizontal">
			<fieldset>
				<legend>Delivery Details</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="deliveryDate">delivery Date (dd/mm/yyyy)</label>
					<div class="col-lg-10">
						<form:input id="deliveryDate" path="deliveryDate" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="doorNo">Door No</label>
					<div class="col-lg-10">
						<form:input id="doorNo" path="deliveryAddress.doorNo" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName">Street Name</label>
					<div class="col-lg-10">
						<form:input id="streetName" path="deliveryAddress.streetName." type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="regionName">Area Name</label>
					<div class="col-lg-10">
						<form:input id="regionName" path="deliveryAddress.regionName" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State</label>
					<div class="col-lg-10">
						<form:input id="state" path="deliveryAddress.state" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">country</label>
					<div class="col-lg-10">
						<form:input id="country" path="deliveryAddress.country" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">Zip Code</label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="deliveryAddress.zipCode" type="text"
							class="form:input-large" />
					</div>
				</div>

				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">back</button>
						
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add"  name="_eventId_deliveryDetailsCollected"/>
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
