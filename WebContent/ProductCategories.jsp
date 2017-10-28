<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Including the style sheets  -->
<link rel="stylesheet" href="styles/bootstrap-grid.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap-reboot.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="styles/styles.css" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">
<!-- Naveen -->
<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="styles/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="styles/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="styles/owl.carousel.css">
<link rel="stylesheet" href="styles/responsive.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Naveen-End -->

<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js">
	
</script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript"
	src='https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.18/vue.min.js'></script>

<title>Product Catalog</title>
</head>
<%@include file="Header.jsp"%>
<body background="images/colorful_note.jpg">
	<div class="container-fluid">
		<div class="row" id="productCatalogue">
			<!-- 	<div class="col-sm-4" id="countryClass"> -->

			<div class="w3-cell-row">
				<div id="search-bar" class="w3-container w3-cell w3-mobile">
					<input type="text" name="search" placeholder="Search.."
						style="width: 80%;" />
				</div>
				<div id="category-select-box" class="w3-container w3-cell w3-mobile">
					<div>
						<p>Select Category:</p>
					</div>
					<div>
						<select id="selectCategory" name="selectCategory" class="field"
							style="width: 40%;">
							<%-- <c:forEach var="category" items="${category}">
								<option value="${category}"></option>
							</c:forEach> --%>
							<c:forEach items="${category}" var="category">
       			 <option value="${category}"><c:out value="${category}" /></option>
    							</c:forEach>
							<!-- 							<option value="">Country</option>
							<option value="">Pop</option>
							<option value="">Rock</option> -->
						</select>
					</div>
				</div>
				<div class="cart_right" class="w3-container w3-cell w3-mobile">
					<div class="cart_box" style="width: 100%; font-size: smaller;">
						<a href="Cart.jsp">
							<h3>
								<span class="simpleCart_total">$0.00</span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity">0</span>
								items)<img src="images/bag.png" alt="">
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty cart</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div class="single-product-area">
				<div class="zigzag-bottom"></div>
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<a href="#openModal"> <img src="images/product-1.jpg"
										alt="">
									</a>
								</div>
								<h2>
									<a href="#openModal">Product1</a>
								</h2>

								<!-- Modal Box -->
								<div id="openModal" class="modalDialog">
									<div class="adjustModal">
										<a href="#close" title="Close" class="close">X</a>

										<h2>Crash My Party</h2>

										<div class="w3-cell-row">
											<div class="w3-container w3-gray w3-cell w3-mobile">
												<img class="modalImg" src="images/product-1.jpg" alt="">
											</div>
											<div class="w3-container w3-cell w3-mobile">
												<p>Artist: Luke Bryan</p>
												<p>Release date: 13 August 2013</p>
												<p>Producer: Jeff Stevens</p>
												<p>Awards: Billboard Music Award for Top</p>
												<p>Country Album Genre: Country music</p>
											</div>
										</div>

										<div class="product-option-shop">
											<div>
												<a class="add_to_cart_button" data-quantity="1"
													data-product_sku="" data-product_id="70" rel="nofollow"
													href="ProductCategories">Add to cart</a>
											</div>
											<div class="product-carousel-price">
												<ins>$89.00</ins>
												<del>$99.00</del>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal Box -->

								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="ProductCategories">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-2.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-3.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-4.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-5.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-2.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-3.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-4.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-2.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-1.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-3.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="images/product-4.jpg" alt="">
								</div>
								<h2>
									<a href="">Apple new mac book 2015 March :P</a>
								</h2>
								<div class="product-carousel-price">
									<ins>$899.00</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Add to cart</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>





			<!-- <input type="image" src="images/CountryMusic.jpg" name="saveForm" class="btTxt submit" id="country"onClick="loadmyDiv('country')" />
				<a href="#" onclick="hidemyDiv('country')" id="countryClose">Close</a> -->
		</div>

		<!-- <div class="col-sm-4" id="pop"><input type="image" src="images/PopMusic.jpg" name="saveForm" class="btTxt submit" id="pop"/></div>
			<div class="col-sm-4" id="rock"><input type="image" src="images/RockMusic.jpg" name="saveForm" class="btTxt submit" id="rock"/></div> -->
	</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>



</html>