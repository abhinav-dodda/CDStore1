package com.musicBonanza.business;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;

public class OrderProcessManager {
	
	public String getAccount(String userName, String password) throws IOException, SQLException{
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		ResultSet resultSet = orderProcessDao.getAccount(userName,password);
		if(resultSet != null) {
		while(resultSet.next()) {
			if(resultSet.getString("Username").equals(userName)) {
				response = "success";
			}
			else {
				response = "failure";
			}
		}
		}
		return response;
		}
	
	
	    public String createAccount(User user) throws IOException{
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		Result resultSet = orderProcessDao.createAccount(user);
		if(resultSet==null) {
			response = "success";
		}
		else {
			response = "failure";
		}
		return response;
		}

	
	
	
}
