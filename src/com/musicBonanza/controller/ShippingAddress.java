package com.musicBonanza.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

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

import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class ShippingAddress
 */
@WebServlet("/ShippingAddress")
public class ShippingAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShippingAddress() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * doPost method for add Shipping address
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @throws ServletException
	 * 
	 * @throws IOException
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		/*if (user == null) {
			String message = "User not logged in";
		} else {*/
		user= new User();
			String username = "raman";
			String street = request.getParameter("streetAddress");
			String province = request.getParameter("province");
			String country = request.getParameter("country");
			String zip = request.getParameter("zip");
			String phone = request.getParameter("phone");
			Shipping shipping = new Shipping();
			shipping.setStreetAddress(street);
			shipping.setProvince(province);
			shipping.setCountry(country);
			shipping.setZipCode(zip);
			shipping.setPhone(phone);
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "orderProcess/createShipping");
			/*String input = "{\"username\":\"" + username + "\",\"street\":\"" + street + "\",\"province\":\"" + province + "\",\"country\":\"" + country
					+ "\",\"zip\":\"" + zip + "\",\"phone\":\"" + phone + "\"}";*/
			ClientResponse webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).
					type("application/json").post(ClientResponse.class, shipping);

			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				String shippingId = webServiceResponse.getEntity(String.class);
				if(shippingId != null && Integer.valueOf(shippingId) != 0){
					user.setShippingId(Integer.valueOf(shippingId));
					user.setUsername(username);
					webResource = client.resource(Constants.localhostUrl + "orderProcess/updateUserShipping");
					webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).
							type("application/json").post(ClientResponse.class, user);
					responseCode = webServiceResponse.getStatus();
					System.out.println("POST Response Code :: " + responseCode);
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						String responseMsg = webServiceResponse.getEntity(String.class);
						if(responseMsg =="success"){
							request.setAttribute("shippingid", user);
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher("/OrderCheckOut.jsp");
							dispatcher.forward(request, response);
						}
						else{
							System.out.println("User details not updated with shipping Id");
						}
					}else{
						System.out.println("POST request not worked");
					}
				} else{
					System.out.println("POST request not worked");
				}

			} else {
				System.out.println("POST request not worked");
			}
		//}

	}

	// TODO Auto-generated method stub
}