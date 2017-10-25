function validateLogin(){
	//var user = $('#username').val();
	//var pwd = $('#pass').val();
	var username=$('#user').val();
	var password=$('#pass').val();
	
	if (!(username && password)){
		alert("Please add both username and password");
	}	
}

var check = function() {
	  if (document.getElementById('signupPassword').value ==
	    document.getElementById('ConfirmsignupPassword').value) {
	   // document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	   // document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}