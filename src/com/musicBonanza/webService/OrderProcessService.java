package com.musicBonanza.webService;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.business.OrderProcessManager;
import com.musicBonanza.dao.OrderProcessDao;

@Path("/orderProcess")
public class OrderProcessService {
	
	
	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount() throws IOException {
		
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
