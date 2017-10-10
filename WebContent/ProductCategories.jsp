<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles/styles.css">
<title>Product Catalog</title>
</head>
<body background="images/music1.png">
	<div class="container" align="center">
	<h2 align="center"><font face="Matura MT Script Capitals" color="orange" size="200"><strong> Music Bonanza </strong></font></h2>
		<table class="table">
			<tr>
				<td class="form-title">Select Genre : &nbsp;</td>
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