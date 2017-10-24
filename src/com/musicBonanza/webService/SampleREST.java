package com.musicBonanza.webService;

import java.io.IOException;

import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.business.LoginManager;

@Path("/userLogin")
public class SampleREST implements ServletContextListener{
	@GET
	@Path("/getLogin")
	  @Produces(MediaType.APPLICATION_JSON)
	  public String sayPlainTextHello() throws IOException {
		//LoginManager loginManager = new LoginManager();
		return "success"; //loginManager.login(username,password);
	  }	
	
	/*@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	  public String sayPlainTextHello(JsonObject jsonObj) throws IOException {
		String username = jsonObj.getString("username");
		String password = jsonObj.getString("password");
		LoginManager loginManager = new LoginManager();
		return loginManager.login(username,password);
	  }*/

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext ctx = arg0.getServletContext();
	}	
}
