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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/css/tether.min.css">


<!-- Including the java script files -->
<script type="text/javascript" src="validations/jquery.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles/styles.css">
<title>Product Catalog</title>
</head>
<%@include file="Header.jsp" %>
<body background="images/music1.png">
	<div class="container" align="center">
	<h2 align="center"><font face="Matura MT Script Capitals" color="orange" size="200"><strong> Music Bonanza </strong></font></h2>
		<table class="table">
			<tr>
				<td>Select Genre :</td>
				<td><select name="Genre" class="form-fi">

						<option value="Rock" class="form-fi" id="Rock"> Rock </option>
						<option value="Pop" class="form-fi" id="Pop"> Pop </option>
						<option value="Country" class="form-fi" id="Country"> Country </option>
				</select></td>
			</tr>
		</table>
	</div>
	
	<%@ include file="Footer.jsp"%>
</body>



</html>