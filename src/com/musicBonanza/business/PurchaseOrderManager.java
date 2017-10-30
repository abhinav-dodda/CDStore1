package com.musicBonanza.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.dao.PurchaseOrderDao;
import com.musicBonanza.entity.PurchaseOrder;

/**
 * 
 * @author Gurpreet
 * Business Tier Class for handling purchase order functionalities
 */
public class PurchaseOrderManager {
	
	/*
	 * Method to create order 
	 * @params purchaseOrder
	 * @return purchaseOrderId
	 */
	public int createOrder(PurchaseOrder purchaseOrder) throws Exception{
		PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
		int purchaseOrderId = purchaseOrderDao.createOrder(purchaseOrder);
		return purchaseOrderId;
	}
	
	/*
	 *  Method to confirm the order and update the order status
	 * @params purchaseOrder
	 * @return purchaseOrderId
	 */
	public String confirmOrder(int purchaseOrderId) throws Exception{
		String response = null;
		PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
		int rowNum = purchaseOrderDao.confirmOrder(purchaseOrderId);
		if (rowNum != 0) {
			response = "success";
		} else {
			response = "failure";
		}
		return response;
	}
			
}
