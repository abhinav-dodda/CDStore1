<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<script type="text/javascript" src="validations/validation.js"></script>
<html>
<head>
<title>Music Bonanza</title>
</head>
<body>
	<div class="row site-header">
		<div class="col-sm-7 site-title">
			<span>
				<strong><a href="Home.jsp">Music Bonanza</a></strong>
			</span>
		</div>
		<div class="col-sm-5">
		<nav class="navbar navbar-toggleable-sm navbar-dark pull-right">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp"><i class="fa fa-home fa-fw" aria-hidden="true"></i> Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">AboutUs</a>
      </li>
      <li class="nav-item">
<<<<<<< HEAD
         <a class="nav-link" href="ProductCategories.jsp">Product Catalog</a>
	  </li>
	  <li class="nav-item">
        <a class="nav-link" href="Login.jsp">SignIn</a>
=======
        <a class="nav-link" href="ShoppingCartServlet">MyCart</a>
      </li>
      
      <li class="nav-item"><a class="nav-link"
							href="ProductCategoryServlet">Product Catalog</a></li>
							<li class="nav-item">
        <a class="nav-link" href="/MusicBonanza/Login">SignIn</a>
>>>>>>> branch 'phase1' of https://Nandyie@bitbucket.org/gsara017/musicbonanza.git
      </li>
	  
	  <%
	  HttpSession usersession = request.getSession();
	  if(usersession.getAttribute("username") != null)
	  {
		  
		  System.out.println("user logged in");
	  %>
      <li class="nav-item">
        <a class="nav-link" href="Cart.jsp">MyCart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">SignOut</a>
      </li>
      <%
      }
	  else
	  {
		  System.out.println("user not logged in");
	  }
      %>
    </ul>
  </div>
</nav>
		</div>
	</div>
</body>

</html>