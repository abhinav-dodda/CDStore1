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
			<div class="login-form-main-message"></div>
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
				<input type="submit" class="login-button" value="Login"><i class="fa fa-chevron-right"	></i>
				</div>
				<br>
			<div class="etc-login-form">
				<p>Forgot your password? <a href="###">click here</a></p>
				<p>New user? <a href="UserRegistration.jsp">Create new account</a></p>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
</div>
</div>

</div>
<div class="col-sm-5"></div>
<%@ include file="Footer.jsp"%>
</div>
</body>
</html>