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
<%
ArrayList<CD> list = new ArrayList<CD>();
list = (ArrayList<CD>)session.getAttribute("cart");
if(list == null)
{
%>
  <div class="container-fluid" style="margin-top:5%;">

	<div class="row">
        <div class="jumbotron" style="box-shadow: 2px 2px 4px #000000;">
            <h2 class="text-center">Your Shopping Cart is empty!. Hope you have not added any products to the cart.<span style="color:#F89406;"> Use the below button to navigate to the </span><span style="color:#26A65B;">Product Catalog Page</span></h2>
            <center>
	            <div class="btn-group" style="margin-top:50px;">
	               <a href = "ProductCategories.jsp" class="btn btn-lg btn-primary">Take Me There</a>
	            </div>
            </center>
        </div>
	</div>
</div>	
<%
}
else
{
	
%>
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
		int quantity = 1;
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
							<h6 class="product-name"><strong><%=c.getProductName()  %></strong></h6><h3><small><%=c.getProdCat()  %></small></h3>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h5><font size =3><strong><%=c.getProdPrice()  %><span class="text-muted">  x </span></strong></font></h5>
							</div>
							<div class="col-xs-4">
								<select id="selectQuantity" name="selectQuantity" class="field"
									                                      style="height: 80%;width: 40%;">
							            <option value="<%= quantity %>">1</option>
										<option value="<%= quantity %>">2</option>
										<option value="<%= quantity %>">3</option>
										<option value="<%= quantity %>">4</option>
										<option value="<%= quantity %>">5</option>
										<option value="<%= quantity %>">6</option>
										<option value="<%= quantity %>">7</option>
										<option value="<%= quantity %>">8</option>
										<option value="<%= quantity %>">9</option>
										<option value="<%= quantity %>">10</option>
								</select>
								
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
              
				  <div class="col-xs-10">
					<h4 class="text-right">Total Amount: <strong>  <%= totalPrice %>$</strong></h4>
				  </div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="text-center">
							<div class="col-xs-3">
								<button type="button" class="btn btn-primary" onclick="ShoppingCartServlet?action=update">
									Update cart
								</button>
							</div>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-success btn-block" onclick="location.href='ShoppingCartServlet?action=checkout?totalPrice=<%= totalPrice %>'">
								Checkout
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
}
%>

<%@ include file="Footer.jsp"%>
</body>
</html>