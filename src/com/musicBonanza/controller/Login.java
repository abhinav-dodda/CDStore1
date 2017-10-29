package com.musicBonanza.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.musicBonanza.dao.*;
import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
/**
 * Servlet Implementation class Login
 */

   // Servlet implementing login functionality

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getAttribute("navigation") == null){
			response.sendRedirect("Login.jsp");
		}
		else if(request.getAttribute("navigation") == "OrderCheckOut"){
			response.sendRedirect("OrderCheckOut.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	/*doPost method for implementing Login functionality 
	 * @param request
	 * @param response
	 * @throws ServletException 
	 * @throws IOException*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		   
		//Nandhini: session attribute set for login details
		HttpSession session = request.getSession();
		session.setAttribute("username",userName);
		
		// Calling Web Service to get Account details
		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl+"orderProcess/getAccount");
        String input = "{\"userName\":\""+userName+"\",\"password\":\""+password+"\"}";
        ClientResponse webServiceResponse = webResource.type(MediaType.APPLICATION_JSON)
           .post(ClientResponse.class, input);
        		System.out.println("Web servcie response: "+webServiceResponse);
		int responseCode = webServiceResponse.getStatus();
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			String output = webServiceResponse.getEntity(String.class);
			JSONParser parser = new JSONParser();
			try {
				System.out.println("got output");
				JSONObject json = (JSONObject)parser.parse(output);
				if(json.get("username") == userName){
					if(request.getAttribute("navigation") == "OrderCheckOut"){
						response.sendRedirect("/OrderCheckOut.jsp");
					}
					else{
						response.sendRedirect("/Home.jsp");
					}
				}
				else{
					String message = "Username or password is incorrect";
					request.setAttribute("message",message);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String message = "Username or password is incorrect";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
			System.out.println("POST request not worked");
		}

	}

}