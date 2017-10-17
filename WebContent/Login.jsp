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
<body background="">

<script type="text/javascript">
function validatelogin(){
	
	//var user = $('#username').val();
	//var pwd = $('#pass').val();
	var user=document.getElementsByName("username").value;
	var pass1=document.getElementsByName("pass").value;
	
	if ( user == "raman" && pass1 == "raman123"){
		alert ("Login successfully");
		window.location = "home.jsp";
		}
			
	//if(username.value == 'abc' && password.value == '123'){
		//alert("login sucessfull");
		//windows.location="index.jsp";
		//return false;
	//}
	else {
		alert("Invalid username or password");
		}	
}

</script>

<div class="container-fluid">
<%@ include file="Header.jsp"%>
		<h2 align="center">
			<font face="Matura MT Script Capitals" color="orange" size="200"><strong>
					Music Bonanza </strong></font>	</h2>
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<div class="text-center" style="padding:50px 0" align="center">
	<div class="logo">Login</div>
	<!-- Main Form -->
	<br>
	<div class="login-form-1">
		<form id="login-form" class="text-left" method="post">
			<div class="login-form-main-message"></div>
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="username" required>
					</div>
					<br>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="pass" name="pass" placeholder="password" required>
					     <span id="message"></span>
					</div>
					<div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div>
			<div class= login-button>
				<input type="submit" class="login-button" value="Login"><i class="fa fa-chevron-right" onsubmit="return validateLogin();"></i>
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
<div class="col-sm-3"></div>
<%@ include file="Footer.jsp"%>
</div>
</body>
</html>