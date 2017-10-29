package com.musicBonanza.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;
import com.musicBonanza.entity.PurchaseOrderItem;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/OrderCheckOut")
public class OrderCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			request.setAttribute("navigation", "OrderCheckOut");
			 RequestDispatcher dispatcher =
			 getServletContext().getRequestDispatcher("Login.jsp");
			 dispatcher.forward(request, response);
		} else {
			User user = new User();
			user.setUsername("raman");//username
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "orderProcess/getAccountByUsername");
			ClientResponse webServiceResponse = webResource.type("application/json").post(ClientResponse.class,
					user.getUsername());

			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				User responseUser = webServiceResponse.getEntity(User.class);
				if (responseUser != null) {
					webResource = client.resource(Constants.localhostUrl + "orderProcess/getShippingById");
					webServiceResponse = webResource.type("application/json").post(ClientResponse.class,
							responseUser.getShippingId());
					responseCode = webServiceResponse.getStatus();
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						Shipping shipping = webServiceResponse.getEntity(Shipping.class);
						if(shipping != null){
						request.setAttribute("username", user.getUsername());
						request.setAttribute("street", shipping.getStreetAddress());
						request.setAttribute("province", shipping.getProvince());
						request.setAttribute("country", shipping.getProvince());
						request.setAttribute("zip", shipping.getZipCode());
						request.setAttribute("phone", shipping.getPhone());
						request.setAttribute("shippingid", shipping.getShippingId());
						Calendar now = Calendar.getInstance();
						System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
								+ now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

						// add days to current date using Calendar.add method
						now.add(Calendar.DATE, 4);

						String expectedDeliveryDate = "Expected Delivery Date : " + (now.get(Calendar.MONTH) + 1) + "-"
								+ now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);// expectedDeliveryDate.a
						request.setAttribute("expectedDeliveryDate", expectedDeliveryDate);
						// session.getAttribute("user");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/OrderCheckOut.jsp");
						dispatcher.forward(request, response);
						}
						else{
							request.setAttribute("user",responseUser);
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher("/Shipping.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						String message = "Something went wrong. Please try again after sometime.";
						response.sendRedirect("/MusicBonanza/ShippingAddress.jsp");
					}
				} else {
					String message = "Username or password is incorrect";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MusicBonanza/Login.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("POST request not worked");
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get details of logged customer from session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			String message = "Please login to place order";
			// redirect to Login jsp
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MusicBonanza/Login.jsp");
			dispatcher.forward(request, response);
		} else {
			User user = new User();
			user.setUsername("raman");//username
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setShippingId(1);// request.getParameter("shippingid");
			purchaseOrder.setUser(user);
			purchaseOrder.setTotalAmount(10);// request.getParameter("totalAmount");
			purchaseOrder.setTotalQuantity(3);// request.getParameter("totalQuantity");
			purchaseOrder.setTaxes(5);// request.getParameter("taxes");
			List<PurchaseOrderItem> products = new ArrayList<PurchaseOrderItem>();
			for (int i = 1; i < 3; i++) {
				PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
				purchaseOrderItem.setCdPrice(10.5);
				purchaseOrderItem.setCdId("cd00" + i);
				products.add(purchaseOrderItem);
			}
			purchaseOrder.setPurchaseOrderItems(products);
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "orderProcess/createOrder");
			ClientResponse webServiceResponse = webResource.type("application/json").post(ClientResponse.class,
					purchaseOrder);

			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				int purchaseOrderId = webServiceResponse.getEntity(Integer.class);
				if (0 != purchaseOrderId) {
					request.setAttribute("purchaseOrderId",purchaseOrderId);
					response.sendRedirect("/MusicBonanza/Payment.jsp");
				} else {
					String message = "Something went wrong. Please try after sometime";
					request.setAttribute("message", message);
					request.setAttribute("purchaseOrder",purchaseOrder);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderCheckOut.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("POST request not worked");
			}

		}

	}
}
