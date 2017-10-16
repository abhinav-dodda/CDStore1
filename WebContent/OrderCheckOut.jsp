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
<link rel="stylesheet" href="styles/font-awesome.min.css" type="text/css">
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
			<div class="col-sm-4">
				<div class="section-title">
					<strong>Delivery Address</strong>
				</div>
				<address class="order-checkout-content">
					<div>
						<strong>Gurpreet Saran</strong>
					</div>
					<div>Apt #314</div>
					<div>2201 Riverside Drive</div>
					<div>Ottawa, ON</div>
					<div>Canada</div>
				</address>
				<div>
					<button type="button" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="section-title">
					<strong>Order Details</strong>
				</div>
				<div class="row order-checkout-content">
					<div class="col-sm-6">
						<div>
							<label>Expected Delivery Detail: 25 Oct, 2017</label>
						</div>
						<div>
							<label>Items Ordered: 2</label>
						</div>
						<div>
							<label>Order ID: 1342</label>
						</div>
					</div>
					<div class="col-sm-6">
					<section>
						<div>
							<label>Order Total: $300</label>
						</div>
						<div>
							<label>Delivery Charges: $30</label>
						</div>
						<div>
							<label>Discount: $10</label>
						</div>
						<div>
							<label>Tax: $5</label>
						</div>
						<div>
							<label>Total: $325</label>
						</div>
						</section>
						<div>
							<button type="button" class="btn btn-primary">Pay <i class="fa fa-usd" aria-hidden="true"></i></button>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>
