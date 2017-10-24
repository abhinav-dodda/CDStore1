package com.musicBonanza.WebServicesClient;

import java.io.IOException;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.business.LoginManager;
@Path("/userLogin")
public class SampleREST {
/*	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public String sayPlainTextHello(@PathParam("username") String username,@PathParam("password") String password ) throws IOException {
		LoginManager loginManager = new LoginManager();
		return loginManager.login(username,password);
	  }	*/
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	  public String sayPlainTextHello(JsonObject jsonObj) throws IOException {
		String username = jsonObj.getString("username");
		String password = jsonObj.getString("password");
		LoginManager loginManager = new LoginManager();
		return loginManager.login(username,password);
	  }	
}
