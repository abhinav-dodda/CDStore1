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
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(params);
			System.out.println(json.get("userName"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OrderProcessManager orderProcessManager = new OrderProcessManager();
		String response = orderProcessManager.getAccount("raman","raman123");

		// LoginManager loginManager = new LoginManager();
		return "success"; // loginManager.login(username,password);
	}
	
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createAccount() throws IOException {
		
		return "success";
	}
}
