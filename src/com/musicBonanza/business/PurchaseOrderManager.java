package com.musicBonanza.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.dao.DBManager;
import com.musicBonanza.dao.PurchaseOrderDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Result;

public class PurchaseOrderManager {

	public int createOrder(PurchaseOrder purchaseOrder){
		PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
		int purchaseOrderId = purchaseOrderDao.createOrder(purchaseOrder);
		return purchaseOrderId;
	}
	
	// Method to confirm the order and update the order status
	
			public String confirmOrder(int purchaseOrderId) throws SQLException{
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
