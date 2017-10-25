package com.musicBonanza.webService;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orderProcess")
public class OrderProcessService {
	
	
	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount() throws IOException {
		// LoginManager loginManager = new LoginManager();
		return "success"; // loginManager.login(username,password);
	}
}
