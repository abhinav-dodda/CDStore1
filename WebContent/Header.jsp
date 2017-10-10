<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">


<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>

<title>Music Bonanza</title>
</head>
<body background="images/music1.png">
<nav class="navbar navbar-toggleable-md navbar-light bg-faded pull-right">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">AboutUs</a>
      </li>
           <li class="nav-item">
        <a class="nav-link" href="ProductCategories.jsp">Product Catalog</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Sign In</a>
        <sub> Are you Not a Member Yet? 
        <a href="#">Register Here!!! </a>
        </sub>
      </li>

    </ul>
  </div>
</nav>
<div class="container">

        
<h2 align="center"><font face="Matura MT Script Capitals" color="orange" size="200"><strong> Music Bonanza </strong></font></h2>
	
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleControls" data-slide-to="1"></li>
      <li data-target="#carouselExampleControls" data-slide-to="2"></li>
      <li data-target="#carouselExampleControls" data-slide-to="3"></li>
    </ol>
  <div class="carousel-inner" role="listbox">
  
    <div class="carousel-item active">
      <img src="images/country.jpg" width="460" height="460"/>
    </div>
    
    <div class="carousel-item">
      <img src="images/pop.jpg" width="460" height="460" />
    </div> 	
    
    <div class="carousel-item">
      <img src="images/rap.jpg" width="460" height="460" />
    </div>
    
    <div class="carousel-item">
      <img src="images/hiphop.jpg" width="460" height="460"/>
    </div>
    
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  
</div>

	</div>	
<div align="center">
	<footer class="footer">
          <a href="Home.jsp" class="form-title">Home</a> | <a href="Aboutus.jsp" class="form-title">About US</a> | <a href="Aboutus.jsp" class="form-title">Contact</a>
          <p class="hyper"><a href="Home.jsp" class="form-title">Trial Blazers</a>@2017 AllRights Deserved Design by Code Pirates</p>
          </footer>
          </div>	
</body>

</html>