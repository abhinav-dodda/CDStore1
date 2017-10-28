package com.musicBonanza.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.PurchaseOrderItem;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.utils.Constants;

public class PurchaseOrderDao {
	
	public int createOrder(PurchaseOrder purchaseorder){
		int insertRowId = 0;
		try {
		//insert into address 
		Shipping shipping = purchaseorder.getShipping();
		List<String> parameters = new ArrayList<>();
		parameters.add(shipping.getStreetAddress());
		parameters.add(shipping.getProvince());
		parameters.add(shipping.getCountry());
		parameters.add(shipping.getZipCode());
		parameters.add(shipping.getPhone());
		insertRowId = DBManager.executePreparedSQL("insertIntoAddress", parameters);
		//insert into PO
		parameters.clear();
		parameters.add(purchaseorder.getUser().getLastName());
		parameters.add(purchaseorder.getUser().getFirstName());
		parameters.add("PENDING");
		parameters.add(""+insertRowId);
		parameters.add(""+purchaseorder.getTotalamount());
		parameters.add(""+purchaseorder.getTotalQuantity());
		parameters.add(""+purchaseorder.getTaxes());
		insertRowId = 0;
		insertRowId = DBManager.executePreparedSQL("insertIntoPurchaseOrder", parameters);
		//insert into POItem
		parameters.clear();
		List <PurchaseOrderItem> itemsList = new ArrayList<PurchaseOrderItem>();
		for(PurchaseOrderItem item : itemsList){
			parameters.add(""+insertRowId);
			parameters.add(""+item.getCdId());
			parameters.add(""+item.getCdPrice());
			DBManager.executeSQL("insertIntoPurchaseOrderItem", parameters);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Constants.dataNotSaved);
		}
		if(0 != insertRowId){
			System.out.println(Constants.dataSaved);
		}
		return insertRowId;
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
				parameters.add("" + purchaseOrder.getShipping());
				
				//executing SQL query to update the order status in the database
				Result result;
				result = DBManager.executeSQL("confirmOrder", parameters);
				return result;
			}
}
