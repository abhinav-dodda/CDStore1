function validateLogin(){
	//var user = $('#username').val();
	//var pwd = $('#pass').val();
	var username=$('#user').val();
	var password=$('#pass').val();
	
	if ( username == "raman" && password == "raman123"){
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
	/*if(username && password){
		var url = 'http://localhost:7002/MusicBonanza/rest/userLogin/login';//?'+username+'&'+password;
		$.ajax({
			url : url,
			type : "POST",
			data : {
				'username' : 'raman',
				'password' : 'raman123'
			},
			success : function(response){
				console.log(response);
			}
		});
	}
	else{
		console.log()
	}*/
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