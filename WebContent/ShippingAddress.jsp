<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Including the style sheets  -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css"> -->
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="styles/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/styles.css" type="text/css">

<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>

<title>Order Check Out</title>
</head>
<body id="order-checkout-body">
	<div class="container-fluid">
		<%@ include file="Header.jsp"%>
		<div class="row order-checkout-div">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form id="shipping-address-form" method="post"
					onsubmit="saveShippingAddress()">
					<div class="form-group">
						<label for="shipping-name">Name</label> <input type="text"
							class="form-control" id="shipping-name" placeholder="Enter name">
					</div>
					<div class="form-group">
						<label for="street">Street Address</label> <input type="text"
							class="form-control" id="street" placeholder="Apartment/Street">
					</div>
					<div class="form-group">
						<label for="city">City</label> <input type="text"
							class="form-control" id="city">
					</div>
					<div class="form-group">
						<label for="province">Province</label> <input type="text"
							class="form-control" id="province">
					</div>
					<div class="form-group">
						<label for="postal-code">Postal Code</label> <input type="text"
							class="form-control" id="postal-code"
							placeholder="Postal code without spaces">
					</div>
					<button type="submit" class="btn btn-primary">Save
						changes</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>


