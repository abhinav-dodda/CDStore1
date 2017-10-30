package com.musicBonanza.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.PurchaseOrderItem;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.utils.Constants;

public class PurchaseOrderDao {
	
	public int createOrder(PurchaseOrder purchaseorder) throws Exception{
		int insertRowId = 0;
		int rowNum = 0;
		try {
		//insert into address 
		/*Shipping shipping = purchaseorder.getShipping();
		
		parameters.add(shipping.getStreetAddress());
		parameters.add(shipping.getProvince());
		parameters.add(shipping.getCountry());
		parameters.add(shipping.getZipCode());
		parameters.add(shipping.getPhone());
		insertRowId = DBManager.executePreparedSQL("insertIntoAddress", parameters);*/
			
		//insert into PO
		
		List<String> parameters = new ArrayList<>();
		parameters.add(purchaseorder.getUser().getLastName());
		parameters.add(purchaseorder.getUser().getFirstName());
		parameters.add("PENDING");
		parameters.add(""+purchaseorder.getShippingId());
		parameters.add(""+purchaseorder.getTotalAmount());
		parameters.add(""+purchaseorder.getTotalQuantity());
		parameters.add(""+purchaseorder.getTaxes());
		insertRowId = 0;
		insertRowId = DBManager.executePreparedSQL("insertIntoPurchaseOrder", parameters);
		//insert into POItem
		parameters.clear();
		List <PurchaseOrderItem> itemsList = purchaseorder.getPurchaseOrderItems();
		for(PurchaseOrderItem item : itemsList){
			parameters.add(""+insertRowId);
			parameters.add(""+item.getCdId());
			parameters.add(""+item.getCdPrice());
			rowNum = DBManager.executeSQL("insertIntoPurchaseOrderItem", parameters);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Constants.dataNotSaved);
		}
		if(0 != insertRowId && 0 != rowNum){//
			System.out.println(Constants.dataSaved);
		}
		else{
			insertRowId = 0;
		}
		return insertRowId;
	}
	
	// Method to confirm the order and update the order status
				public int confirmOrder(int purchaseOrderId) throws Exception{
					List<String> parameters = new ArrayList<>();
					parameters.add("ORDERED");
					parameters.add(""+purchaseOrderId);
					//executing SQL query to update the order status in the database
					int rowNum = 0;
					rowNum = DBManager.executeSQL("confirmOrder", parameters);
					return rowNum;
				}
}
