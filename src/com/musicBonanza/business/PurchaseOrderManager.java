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
	
		public Result confirmOrder(PurchaseOrder purchaseOrder) throws SQLException{
			List<String> parameters = new ArrayList<String>();
			parameters.add(" " +purchaseOrder.getPurchaseOrderId());
			parameters.add(" "+purchaseOrder.getTotalQuantity());
			parameters.add(" " +purchaseOrder.getPurchaseOrderItems());
			parameters.add(" " + purchaseOrder.getTaxes());
			parameters.add("" + purchaseOrder.getPurchaseOrderStatus());
			parameters.add("" + purchaseOrder.getUser());
			//parameters.add("" + purchaseOrder.getShipping());
			
			//executing SQL query to update the order status in the database
			Result result;
			result = DBManager.executeSQL("confirmOrder", parameters);
			return result;
		}
}
