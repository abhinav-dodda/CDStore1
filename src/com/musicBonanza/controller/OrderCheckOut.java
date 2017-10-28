package com.musicBonanza.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/OrderCheckOut")
public class OrderCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		/*User user = (User) session.getAttribute("user");
		if(user == null){
			request.setAttribute("navigation", "OrderCheckOut");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
		else{*/
			String username = "raman";//user.getUsername();
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl+"orderProcess/getAccountByUsername");
	        String input = "{\"username\":\""+username+"\"}";
	        ClientResponse webServiceResponse = webResource.type("application/json")
	           .post(ClientResponse.class, input);
	       
			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				//User user = from response
				
				String output = webServiceResponse.getEntity(String.class);
				JSONParser parser = new JSONParser();
				try {
					JSONObject json = (JSONObject)parser.parse(output);
					if(json.get("username") !=null){
						webResource = client.resource(Constants.localhostUrl+"orderProcess/getShippingById");
				        input = "{\"shippingid\":\""+json.get("shippingid")+"\"}";
				        webServiceResponse = webResource.type("application/json")
				           .post(ClientResponse.class, input);
				        responseCode = webServiceResponse.getStatus();
				        if (responseCode == HttpURLConnection.HTTP_OK) { // success
				        	output = webServiceResponse.getEntity(String.class);
							parser = new JSONParser();
							json = (JSONObject)parser.parse(output);
							request.setAttribute("username",username);
				        	request.setAttribute("street",json.get("street"));
				        	request.setAttribute("province",json.get("province"));
				        	request.setAttribute("country",json.get("country"));
				        	request.setAttribute("zip",json.get("zip"));
				        	request.setAttribute("phone",json.get("phone"));
				        	Calendar now = Calendar.getInstance();
						    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
							        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

							    // add days to current date using Calendar.add method
							    now.add(Calendar.DATE, 4);

							    System.out.println("Expected Delivery Date : " + (now.get(Calendar.MONTH) + 1) + "-"
							        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));//expectedDeliveryDate.a
				        	request.setAttribute("expectedDeliveryDate",now);
				        	//session.getAttribute("user");
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderCheckOut.jsp");
							dispatcher.forward(request, response);
				        }
				        else{
				        	response.sendRedirect("/ShippingAddress.jsp");
				        }
					}
					else{
						String message = "Username or password is incorrect";
						request.setAttribute("message",message);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
						dispatcher.forward(request, response);
					}
				
				}
				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else {
				System.out.println("POST request not worked");
			}

		//}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Get details of logged customer from session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user == null){
			String message = "Please login to place order";
			//redirect to Login jsp
		}
		else{
			
			String username = request.getParameter("username");
			String street = request.getParameter("streetAddress");
			String province = request.getParameter("province");
			String country = request.getParameter("country");
			String zip = request.getParameter("zip");
			String phone = request.getParameter("phone");
			String totalAmount = request.getParameter("totalAmount");
			String totalQuantity = request.getParameter("totalQuantity");
			String taxes = request.getParameter("taxes");
			String cdId = request.getParameter("productId");
			String cdPrice = request.getParameter("prodPrice");
			
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl+"orderProcess/getAccount");
	        String input = "{\"username\":\""+username+"\",\"street\":\""+street+
	        		"\",\"province\":\""+province+"\",\"country\":\""+country+"\",\"zip\":\""+zip+"\",\"phone\":\""+phone+
	        		"\",\"totalAmount\":\""+totalAmount+"\",\"totalQuantity\":\""+totalQuantity+"\",\"taxes\":\""+taxes+
	        		"\",\"cdId\":\""+cdId+"\",\"cdPrice\":\""+cdPrice+"\"}";
	        ClientResponse webServiceResponse = webResource.type("application/json")
	           .post(ClientResponse.class, input);
	       
			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				response.sendRedirect("Payment.jsp");
			} else {
				System.out.println("POST request not worked");
			}

		}
	
	}
}
