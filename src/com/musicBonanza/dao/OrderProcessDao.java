package com.musicBonanza.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.Helper.Helper;
import com.musicBonanza.utils.Constants;

public class OrderProcessDao {

	public ResultSet getAccount(String userName, String password) throws IOException {
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(userName);
		parameters.add(password);
		
		ResultSet resultSet = DBManager.executeSQL("selectFromUserLogin", parameters);
		return resultSet;
		}
	
	public static int createOrder(OrderProcessDao purchaseorder) {
		
		return 0;
	}

}
