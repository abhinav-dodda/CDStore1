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
<link rel="stylesheet" href="styles/bootstrap-grid.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap-reboot.min.css"
	type="text/css">
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="styles/styles.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" >



<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<title>Login</title>
</head>
<body>

<div class="container-fluid">
<%@ include file="Header.jsp"%>

<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-3">
<div class="text-center" style="padding:50px 0" align="center">
	<div class="logo"></div>
	<!-- Main Form -->
	<br>
	<div class="login-form-1">
		<form id="login-form" action="Login" class="text-left" method="post" onsubmit="validateLogin()">
			<div class="login-form-main-message" style="color:red">${message }</div>
			<input type="hidden" name="navigation" value="${navigation}"/>
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" id="user" name="username" placeholder="" required>
					</div>
					<br>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="pass" name="password" placeholder="" required>
					     <span id="message"></span>
					</div>
					
			<div class= login-button>
				<input type="submit" class="login-button" id="loginButton" value="Login"><!-- <i class="fa fa-chevron-right"	></i> -->
				</div>
				<br>
			<div class="etc-login-form">
				
				<p>New user? <a href="UserRegistration.jsp">Create new account</a></p>
			</div>
		</form>
	</div>
	
	<!-- end:Main Form -->
</div>
</div>
</div>
 <div id="about-us" class="row">
     <div class="container">
     <div class="container bootstrap snippets">
      <div class="row text-center">
        <div class="col-sm-4">
          <div class="contact-detail-box">
            <i class="fa fa-th fa-3x text-colored"></i>
            <h4>Get In Touch</h4>
            <abbr title="Phone">P:</abbr> (343) 987-6543<br>
            E: <a href="mailto:musicbonanza@gmail.com" class="text-muted">musicbonanza@gmail.com</a>
          </div>
        </div><!-- end col -->

        <div class="col-sm-4">
          <div class="contact-detail-box">
            <i class="fa fa-map-marker fa-3x text-colored"></i>
            <h4>Our Location</h4>

            <address>
             800 King Edward Ave,<br>
           Ottawa, ON<br>
          </address>
          </div>
        </div><!-- end col -->

        <div class="col-sm-4">
          <div class="contact-detail-box">
            <i class="fa fa-book fa-3x text-colored"></i>
            <h4>24x7 Support</h4> 
            <h4 class="text-muted">1234 567 890</h4>
          </div>
        </div><!-- end col -->

      </div>
      <!-- end row -->
          
    </div>
      </div>
      <!-- end row -->
  </div>


<%@ include file="Footer.jsp"%>
</div>

</body>
</html>