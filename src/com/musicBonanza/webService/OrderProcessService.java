package com.musicBonanza.webService;

import java.io.IOException;

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

@Path("/orderProcess")
public class OrderProcessService {
	
	
	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount(String params) throws IOException {
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
	public String createAccount() throws IOException {
		
		return "success";
	}
}
