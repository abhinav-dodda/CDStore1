function validateLogin(){
	//var user = $('#username').val();
	//var pwd = $('#pass').val();
	var username=$('#user').val();
	var password=$('#pass').val();
	
	if ( username == "raman" && password == "raman123"){
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