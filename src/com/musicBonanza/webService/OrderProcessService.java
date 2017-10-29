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

@Path("/orderProcess")
public class OrderProcessService {
	
	
	@POST
	@Path("/getAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccount(String params) throws IOException, SQLException {
		JSONObject responseObj = new JSONObject();
		User user = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject)parser.parse(params);
			String userName = (String)json.get("userName");
			String password = (String)json.get("password");
			if(userName != null && password !=null){
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				user = orderProcessManager.getAccount(userName,password);
				if(user!=null){
				responseObj.put("username",user.getUsername());
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseObj.toJSONString();
	}
	
	@POST
	@Path("/getAccountByUsername")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccountByUsername(String params) throws IOException, SQLException {
		JSONObject responseObj = new JSONObject();
		User user = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject)parser.parse(params);
			String userName = (String)json.get("username");
			if(userName != null){
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				user = orderProcessManager.getAccountByUsername(userName);
				if(user!=null){
					responseObj.put("username",user.getUsername());
					responseObj.put("shippingid",user.getShippingId());
					}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseObj.toJSONString();
	}
	
	@POST
	@Path("/createAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createAccount(String params) throws IOException {
	
		String response = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject)parser.parse(params);
			String firstName = (String)json.get("firstName");
			String lastName = (String)json.get("lastName");
			String userName = (String)json.get("userName");
			String email = (String)json.get("email");
			String password = (String)json.get("password");		
			String confirmPassword = (String)json.get("confirmPassword"); 
            
            if(!(firstName!=null) && (lastName!=null) && (userName!=null) && (email!=null) && (password!=null) && (confirmPassword!=null))
            {
            	return "Please fill all the required fields";
            }
            else if(password!=confirmPassword)
            {
            	return "Password Mismatch";
            }
            else{
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
		}
		
		return response;
	}
	
	@POST
	@Path("/createOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createOrder(String params) throws IOException {
		JSONObject responseObj = new JSONObject();
		int purchaseOrderId;
		JSONParser parser = new JSONParser();
		try {
			
			JSONObject json = (JSONObject)parser.parse(params);
			String username = (String)json.get("username");
			String shippingid = (String)json.get("shippingid");
			float totalAmount =  Float.valueOf((String) json.get("totalAmount"));
			int totalQuantity =  Integer.valueOf((String) json.get("totalQuantity"));
			float taxes =  Float.valueOf((String) json.get("taxes"));
			/*String products = (String) json.get("products");
			JSONObject productJson = (JSONObject)parser.parse(products);
			System.out.println(productJson);*/
			if(username == null){
				return "User not logged in";
			}
			else if(!(totalAmount!=0) && (totalQuantity!=0) && (taxes!=0)){
				return "Order details not available";
			}
			/*else if(productList == null){
				return "Ordered items' list not available";
			}*/
			else{
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				User user = orderProcessManager.getAccountByUsername(username);
				user.setUsername(username);
				
				//Hardcoded purchase items to check db insert 
				List<PurchaseOrderItem> products = new ArrayList<PurchaseOrderItem>();
				/*for(int i=1;i<3;i++){
					PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
					purchaseOrderItem.setCdPrice(10.5);
					purchaseOrderItem.setCdId("cd001");
					products.add(purchaseOrderItem);
				}*/
				
				PurchaseOrder purchaseOrder = new PurchaseOrder(user,totalQuantity,totalAmount,taxes,products,Integer.valueOf(shippingid));
            	PurchaseOrderManager purchaseOrderManager = new PurchaseOrderManager();
            	purchaseOrderId = purchaseOrderManager.createOrder(purchaseOrder);
            	responseObj.put("purchaseOrderId",purchaseOrderId);
            	
			}            
            
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseObj.toJSONString();
	}

	@POST
	@Path("/createShipping")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createShipping(String params) throws IOException {
		JSONObject responseObj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			
			JSONObject json = (JSONObject)parser.parse(params);
			String username = (String)json.get("username");
			String street =  (String)json.get("street");
			String province =  (String)json.get("province");
			String country =  (String)json.get("country");
			String zip =  (String)json.get("zip");
			String phone =  (String)json.get("phone");
			if(!(street!=null) && (province!=null) && (country!=null) && (zip!=null) && (phone!=null)){
				return "No shipping information available";
			}
			else if(username == null){
				return "User not logged in";
			}
			else{
				Shipping shipping = new Shipping();
				shipping.setStreetAddress(street);
				shipping.setProvince(province);
				shipping.setCountry(country);
				shipping.setZipCode(zip);
				shipping.setPhone(phone);
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				int shippingId = orderProcessManager.createShipping(shipping,username);
				responseObj.put("shippingId",shippingId);
			}            
            
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseObj.toJSONString();
	}

	@POST
	@Path("/getShippingById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getShippingById(String params) throws IOException {
		JSONObject responseObj = new JSONObject();
		Shipping shipping = null;
		JSONParser parser = new JSONParser();
		try {
			
			JSONObject json = (JSONObject)parser.parse(params);
			String shippingId =  (String)json.get("shippingid");
			if(shippingId == null){
				return "No shipping Id available";
			}
			else{
				OrderProcessManager orderProcessManager = new OrderProcessManager();
				shipping = orderProcessManager.getShippingById(Integer.valueOf(shippingId));
				if(shipping!=null){
					responseObj.put("street",shipping.getStreetAddress());
					responseObj.put("province",shipping.getProvince());
					responseObj.put("country",shipping.getCountry());
					responseObj.put("zip",shipping.getZipCode());
					responseObj.put("phone",shipping.getPhone());
					}
			}            
            
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseObj.toJSONString();
	}
	
	@PUT
	@Path("/confirmOrder")
	@Consumes("application/json")
	@Produces("application/json")
	
	public String confirmOrder(String params) {
		String response=null;
		JSONParser parser =new JSONParser();
			
		try {
			JSONObject json = (JSONObject) parser.parse(params);
			int  purchaseOrderId= (int)json.get("purchaseOrderId");
			User user = new User();
			 user= (User) json.get(user);
			float totalAmount = (float)json.get("totalAmount");
			int totalQuantity = (int)json.get("totalQuantity");
			float taxes = (float)json.get("taxes");
			String purchaseOrderStatus = json.get("purchaseOrderStatus").toString();
			List<PurchaseOrderItem> purchaseOrderItems = (List<PurchaseOrderItem>) json.get("purchaseOrderItem");
			Shipping shipping = new Shipping();
			//shipping = (Shipping) json.get("shipping");
			
			if(purchaseOrderStatus ==Constants.orderConfirmed) {
				PurchaseOrderManager purchaseOrderManager = new PurchaseOrderManager();
				PurchaseOrder purchaseOrder = new PurchaseOrder();
				purchaseOrder.setPurchaseOrderId(purchaseOrderId);
				purchaseOrder.setUser(user);
				purchaseOrder.setTotalAmount(totalAmount);
				purchaseOrder.setTotalQuantity(totalQuantity);
				purchaseOrder.setTaxes(taxes);
				purchaseOrder.setPurchaseOrderStatus(purchaseOrderStatus);
				purchaseOrder.setPurchaseOrderItems(purchaseOrderItems);
				//purchaseOrder.setShippingId(shipping);
				//response =purchaseOrderManager.confirmOrder(purchaseOrder);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}

}
