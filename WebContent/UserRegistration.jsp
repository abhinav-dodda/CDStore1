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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">


<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>

<title>User Registration</title>
</head>
<body>

<div class="container-fluid">
 <%@ include file="Header.jsp" %>

<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form method="POST" action="UserRegistration" role="form">
						<div class="form-group">
							<h2>Create an account</h2>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupName">Your name</label>
							<input id="signupName" type="text" maxlength="50" name="signupname" class="form-control" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label>
							<input id="signupEmail" type="email" name="email" maxlength="50" class="form-control" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label>
							<input id="signupPassword" type="password" name="signupPassword" maxlength="25" class="form-control" length="40" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="ConfirmsignupPassword">Confirm Password</label>
							<input id="ConfirmsignupPassword" type="password" name="ConfirmsignupPassword" maxlength="25" class="form-control"  onkeyup="check();" required>
						    <span id= 'message'></span>
						</div>
						<div class="form-group">
							<button id="signupSubmit" type="submit" class="btn btn-info btn-block">Create your account</button>
						</div>
						<hr>
						<p>Already have an account? <a href="Login.jsp">Sign in</a></p>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
	<%@ include file="Footer.jsp"%>
</div>
</body>
</html>