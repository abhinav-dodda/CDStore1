package com.musicBonanza.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class UserRegistration
 */

  // Servlet implementing Registration of new User 

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*method that handles the registration of new user
	@param request
	@param response
	@throw servletException
	@throw IOException*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieving parameters from UserRegistration.jsp
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName= request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("signupPassword");
		String confirmPassword = request.getParameter("ConfirmsignupPassword");
		
		// Calling Web Service to Create Account
		
		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl+"orderProcess/createAccount");
        String input = "{\"userName\":\""+userName+"\",\"password\":\""+password+"\","+
        		"\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\",\"email\":\""+email+"\", \"confirmPassword\":\""+confirmPassword+"\"}";
        ClientResponse webServiceResponse = webResource.type("application/json")
           .post(ClientResponse.class, input);
        		
		int responseCode = webServiceResponse.getStatus();
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			String responseMsg = webServiceResponse.getEntity(String.class);
			if(responseMsg.contains("required")){
				String message = "Please fill all the required fields";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
				dispatcher.forward(request, response);
			}
			else if(responseMsg.contains("Password")){
				String message = "Password Mismatch";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
				dispatcher.forward(request, response);
			}
			else if(responseMsg.contains("Username already exists")){
                String message = "Username already exists";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
                dispatcher.forward(request, response);
            }
			else{
				response.sendRedirect("Home.jsp");
			}
		} else {
			String responseMsg = webServiceResponse.getEntity(String.class);
			if(responseMsg.contains("Username already exists")){
                String message = "Username already exists";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
                dispatcher.forward(request, response);
            }
			System.out.println("POST request not worked");
		}
	}

}

