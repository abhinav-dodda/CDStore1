<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.musicBonanza.entity.CD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Including the style sheets  -->
<link rel="stylesheet" href="styles/bootstrap-grid.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap-reboot.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="styles/styles.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">



<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<script type="text/javascript" src="validations/PriceCalculations.js"></script>
<title>Shopping Cart</title>

</head>
<body>

<div class="container-fluid">
<%@include file="Header.jsp" %>
<br>
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
							</div>
							<div class="col-xs-6">
								<button type="button" class="btn btn-primary btn-sm btn-block" onclick="window.location='ProductCategories.jsp'">
									<span class="glyphicon glyphicon-share-alt"></span>Continue shopping
								</button>
							</div>
						</div>
					</div>
				</div>
		<div class="panel-body">		
		<% 
		//get the response attribute from servlet
		float totalPrice = 0;
		CD usercart = new CD();
		List<CD> cart = (List<CD>) session.getAttribute("cart");
		for (CD c: cart)
		{
			//usercart = cart.get(i);
		%>
				
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="images/<%=c.getProductId()%>.jpg">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong><%=c.getProductName()  %></strong></h4><h4><small><%=c.getProdCat()  %></small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right" id="price">
								<h5><font size =3><strong><%=c.getProdPrice()  %><span class="text-muted"> X </span></strong></font></h5>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2">
								<button type="button" class="btn btn-link btn-xs" onclick="location.href='ShoppingCartServlet?action=delete&prodId=<%=c.getProductId()%>'">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</div>
						</div>
					</div>
					
					<hr>
			   <%
			   totalPrice += c.getProdPrice();
			   	}
		     
		       %>

				
					<div class="row">
						<div class="text-center">
							<div class="col-xs-3">
								<button type="button" class="btn btn-primary" onclick="ShoppingCartServlet?action=update">
									Update cart
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong><%= totalPrice %>$</strong></h4>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-success btn-block">
								Checkout
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>