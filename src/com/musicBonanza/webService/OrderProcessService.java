package com.musicBonanza.webService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.musicBonanza.business.OrderProcessManager;
import com.musicBonanza.business.PurchaseOrderManager;
import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.PurchaseOrderItem;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;
/**
 * 
 * @author ABHI
 *
 */
@Path("/orderProcess")
public class OrderProcessService {

	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This method is used to Login if user enters his username and password
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public User getAccount(String params) throws Exception {
		User user = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(params);
			String userName = (String) json.get("userName");
			String password = (String) json.get("password");
			if (userName != null && password != null) {
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				user = orderProcessManager.getAccount(userName, password);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;// responseObj.toJSONString();
	}

	@POST
	@Path("/getAccountByUsername")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This account retrieves the user details by username
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User getAccountByUsername(String userName) {
		User user = null;
		try {
			if (userName != null) {
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				user = orderProcessManager.getAccountByUsername(userName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This method is used for user registration
	 * @param params
	 * @return
	 * @throws IOException
	 */

	public String createAccount(String params){

		String response = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(params);
			String firstName = (String) json.get("firstName");
			String lastName = (String) json.get("lastName");
			String userName = (String) json.get("userName");
			String email = (String) json.get("email");
			String password = (String) json.get("password");
			String confirmPassword = (String) json.get("confirmPassword");

			if (!(firstName != null) && (lastName != null) && (userName != null) && (email != null)
					&& (password != null) && (confirmPassword != null)) {
				return "Please fill all the required fields";
			} else if (!password.equals(confirmPassword)) {
				return "Password Mismatch";
			} else {
				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(password);
				user.setEmail(email);
				user.setUsername(userName);
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				response = orderProcessManager.createAccount(user);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains("Duplicate") || e.getMessage().contains("Username already exists")) {
				response = "Username already exists";
			}
			e.printStackTrace();
			return response;
		}
		return response;
	}

	@POST
	@Path("/createOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This method is used to create an order for the user
	 * @param purchaseOrder
	 * @return
	 * @throws Exception
	 */
	public Integer createOrder(PurchaseOrder purchaseOrder) throws Exception {
		int purchaseOrderId = 0;
		if (purchaseOrder.getUser() == null) {
			throw new Exception("User not logged in");
		} else if (!(purchaseOrder.getTotalAmount() != 0) && (purchaseOrder.getTotalQuantity() != 0)
				&& (purchaseOrder.getTaxes() != 0)) {
			throw new Exception("Order details not available");
		} else if (purchaseOrder.getPurchaseOrderItems() == null) {
			throw new Exception("Ordered items' list not available");
		} else {
			OrderProcessManager orderProcessManager = new OrderProcessManager();
			User user = orderProcessManager.getAccountByUsername(purchaseOrder.getUser().getUsername());
			purchaseOrder.setUser(user);
			PurchaseOrderManager purchaseOrderManager = new PurchaseOrderManager();
			purchaseOrderId = purchaseOrderManager.createOrder(purchaseOrder);
		}
		return purchaseOrderId;
	}

	@POST
	@Path("/createShipping")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This method is used to create the shipping details for the customer
	 * @param shipping
	 * @return
	 * @throws Exception
	 */
	public String createShipping(Shipping shipping) throws Exception {
		int shippingId = 0;
		if (!(shipping.getStreetAddress() != null) && (shipping.getProvince() != null)
				&& (shipping.getProvince() != null) && (shipping.getZipCode() != null)
				&& (shipping.getPhone() != null)) {
			throw new Exception("No shipping information available");
		}
		OrderProcessManager orderProcessManager = new OrderProcessManager();
		orderProcessManager.createShipping(shipping);
		return "" + shippingId;
	}

	@POST
	@Path("/getShippingById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
/**
 * This method is used to get the shipping ID of a particular user
 * @param shippingId
 * @return
 * @throws Exception
 */
	public Shipping getShippingById(int shippingId) throws Exception {
		Shipping shipping = null;
		if (shippingId == 0) {
			throw new Exception("No shipping Id available");
		} else {
			OrderProcessManager orderProcessManager = new OrderProcessManager();
			shipping = orderProcessManager.getShippingById(Integer.valueOf(shippingId));
		}
		return shipping;
	}

	@POST
	@Path("/updateUserShipping")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
/**
 * This method updates the user shipping address
 * @param user
 * @return
 * @throws Exception
 */
	public String updateUserShipping(User user) throws Exception {
		String response = null;
		if (user.getUsername() == null) {
			throw new Exception("User not logged in");
		} else {
			OrderProcessManager orderProcessManager = new OrderProcessManager();
			response = orderProcessManager.updateUserShipping(user);
		}
		return response;
	}

	@POST
	@Path("/confirmOrder")
	@Consumes("application/json")
	@Produces("application/json")
/**
 * This method is used to authorize the user order based on payment info and stores shipping info with order
 * @param params
 * @return
 * @throws ParseException
 */
	public String confirmOrder(String params) throws ParseException {
		String response = null;
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(params);
		try {
			String purchaseOrderId = (String) json.get("purchaseOrderId");
			PurchaseOrderManager purchaseOrderManager = new PurchaseOrderManager();
			response = purchaseOrderManager.confirmOrder(Integer.valueOf(purchaseOrderId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
