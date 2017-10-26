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
			String userName = (String)json.get("userName");
			String password = (String)json.get("password");
			if(userName != null && password !=null){
				User user = new User();
				user.setUsername(userName);
				user.setPassword(password);
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				response = orderProcessManager.getAccount(user);
			}
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
			String firstName = json.get("firstName").toString();
			String lastName = json.get("lastName").toString();
			String userName = json.get("userName").toString();
			String email = json.get("email").toString();
			String password = json.get("password").toString();		
            
            if(!(firstName!=null) && (lastName!=null) && (userName!=null) && (email!=null) && (password!=null))
            {
            	return "Please fill all the required fields";
            }
            else{
            	User user = new User();
            	user.setFirstName(firstName);
            	user.setLastName(lastName);
            	user.setPassword(password);
            	user.setEmail(email);
            	user.setUsername(userName);
            	OrderProcessManager orderProcessManager = new OrderProcessManager();
    			response = orderProcessManager.createAccount(user);
            }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}
