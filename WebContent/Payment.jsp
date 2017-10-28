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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script type="text/javascript" src="validations/bootstrap.js"></script>
<script type="text/javascript" src="validations/bootstrap.min.js"></script>
<script type="text/javascript" src="validations/validation.js"></script>
<title>Payment</title>
</head>
<body> 
<%@ include file="Header.jsp"%>
<div class="container">
	<div class="row-fluid">
      <form class="form-horizontal" method="Post">
        <fieldset>
              
          <!-- Name -->
          <div class="form-group">
            <label class="control-label"  for="holder_name">Card Holder's Name</label>
            <div class="controls">
              <input type="text" id="holder_name" name="holder_name" placeholder="" class="input-xlarge" required>
            </div>
          </div>
     
          <!-- Card Number -->
          <div class="form-group">
            <label class="control-label" for="card_number">Card Number</label>
            <div class="controls">
              <input type="text" id="card_number" name="card_number" placeholder="" class="input-xlarge" required>
            </div>
          </div>
     
          <!-- Expiry-->
          <div class="form-group">
            <label class="control-label" for="card_expiry">Card Expiry Date</label>
            <div class="controls">
              <select class="span3" name="expiry_month" id="expiry_month" required>
                <option></option>
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>1
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
              <select class="span2" name="expiry_year" required>
              <option></option>
                <option value="13">2018</option>
                <option value="14">2019</option>
                <option value="15">2020</option>
                <option value="16">2021</option>
                <option value="17">2022</option>
                <option value="18">2023</option>
                <option value="19">2024</option>
                <option value="20">2025</option>
                <option value="21">2026</option>
                <option value="22">2027</option>
                <option value="23">2028</option>
              </select>
            </div>
          </div>
     
          <!-- CVV -->
          <div class="form-group">
            <label class="control-label"  for="card_cvv">Card CVV</label>
            <div class="controls">
              <input type="password" id="card_cvv" name="card_cvv" placeholder="" class="span2" required>
            </div>
          </div>
     
     
          <!-- Submit -->
          <div class="form-group">
            <div class="controls">
              <button class="btn btn-success">Pay Now</button>
            </div>
          </div>
     
        </fieldset>
      </form>
    </div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>