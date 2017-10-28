package com.musicBonanza.business;

import java.sql.SQLException;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.dao.PurchaseOrderDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Result;

public class PurchaseOrderManager {

	public int createOrder(PurchaseOrder purchaseOrder)
	{
		PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
		int purchaseOrderId = purchaseOrderDao.createOrder(purchaseOrder); 
		return purchaseOrderId;
	}
	
	/* Method for updating the order status to confirmed or denied
	 * @param purchaseOrderItem
	 * @return response */ 
	public String confirmOrder(PurchaseOrder purchaseOrder) {
		PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
		String response = null;
		try {
			Result result = purchaseOrderDao.confirmOrder(purchaseOrder);
			//checking the response from the database
			if(result != null) {
				response  = "success";
			}
			else {
				response = "failure";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
}
