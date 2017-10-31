function validateLogin(){
	//var user = $('#username').val();
	//var pwd = $('#pass').val();
	var username=$('#user').val();
	var password=$('#pass').val();
	
	if (!(username && password)){
		alert("Please add both username and password");
	}	
}

function Validate() {
   
		var email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    var password = $('#signupPassword').val();
        var confirmPassword = $('#ConfirmsignupPassword').val();
        if (!filter.test(email.value)) {
            alert('Please provide a valid email address');
            email.focus;
            }
        
        else if (password != confirmPassword) {
            alert("Passwords do not match.");
         }
}

/*var check = function() {
	  if (document.getElementById('signupPassword').value ==
	    document.getElementById('ConfirmsignupPassword').value) {
	   // document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	   // document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}*/