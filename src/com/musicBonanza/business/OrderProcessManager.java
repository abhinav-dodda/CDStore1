package com.musicBonanza.business;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;

public class OrderProcessManager {
	
	public String getAccount(String userName, String password) throws IOException{
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = "failure";
		ResultSet resultSet = orderProcessDao.getAccount(userName,password);
		try {
			if(resultSet.next()) {
				response = "success";
			}
			else {
				response = "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		}
	/*public int createOrder(int[] shoppingCartInfo, PurchaseOrder purchaseOrder, Shipping shippingInfo)
	{
	OrderProcessDao orderProcessDao = new OrderProcessDao();
	
	PurchaseOrder purchaseorder = new PurchaseOrder();
	purchaseorder.setShippings(shippings);
	purchaseorder.setpurchaseOrder(purchaseOrder);
	purchaseorder.setshippingInfo(shippingInfo);
	
	return orderProcessDao.createOrder(purchaseorder);
	}*/
	
	
	
	
	
}
