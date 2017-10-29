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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
			String username = "raman";
			String street = request.getParameter("streetAddress");
			String province = request.getParameter("province");
			String country = request.getParameter("country");
			String zip = request.getParameter("zip");
			String phone = request.getParameter("phone");

			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "orderProcess/createShipping");
			String input = "{\"username\":\"" + username + "\",\"street\":\"" + street + "\",\"province\":\"" + province + "\",\"country\":\"" + country
					+ "\",\"zip\":\"" + zip + "\",\"phone\":\"" + phone + "\"}";
			ClientResponse webServiceResponse = webResource.type("application/json").post(ClientResponse.class, input);

			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				String output = webServiceResponse.getEntity(String.class);
				JSONParser parser = new JSONParser();
				JSONObject json;
				try {
					json = (JSONObject) parser.parse(output);
					request.setAttribute("shippingid", json.get("shippingId"));
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/OrderCheckOut.jsp");
					dispatcher.forward(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Unable to save shipping address");
				}

			} else {
				System.out.println("POST request not worked");
			}
		//}

	}

	// TODO Auto-generated method stub
}