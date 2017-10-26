package com.musicBonanza.webService;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.musicBonanza.business.OrderProcessManager;
import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.User;

@Path("/orderProcess")
public class OrderProcessService {
	
	
	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount(String params) throws IOException, SQLException {
		String response = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject)parser.parse(params);
			String userName = json.get("userName").toString();
			String password = json.get("password").toString();
			OrderProcessManager orderProcessManager = new OrderProcessManager();
			response = orderProcessManager.getAccount(userName,password);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createAccount(String params) throws IOException {
	
		String response = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject)parser.parse(params);
			String name = json.get("signupName").toString();
			String userName = json.get("userName").toString();
			String email = json.get("signupEmail").toString();
			String password = json.get("signupPassword").toString();
			String confirmPassword = json.get("ConfirmsignupPassword").toString();
			
			User user= new User();
			user.setSignupname(name);
			user.setUserName(userName);
            user.setsignupEmail(email);
            user.setsignupPassword(password);
            user.setCofirmsignupPassword(confirmPassword);
            
            if(!(name!=null) && (userName!=null) && (email!=null) && (password!=null) && (confirmPassword!=null))
            {
            	return "Please add User Info";
            }
            else if (!(password==confirmPassword)) 
            {
             return "Paasword donot match";	
            }
            
			OrderProcessManager orderProcessManager = new OrderProcessManager();
			response = orderProcessManager.createAccount(user);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}
