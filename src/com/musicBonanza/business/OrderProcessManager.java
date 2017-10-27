package com.musicBonanza.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.User;

public class OrderProcessManager {

	public String getAccount(User user){
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		ResultSet resultSet;
		try {
			resultSet = orderProcessDao.getAccount(user);
			if (resultSet != null) {
				while (resultSet.next()) {
					if (resultSet.getString("Username").equals(user.getUsername())) {
						response = "success";
					} else {
						response = "failure";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception from Database");
			e.printStackTrace();
		}
		
		return response;
	}

	public String createAccount(User user) {
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		try {
			Result result = orderProcessDao.createAccount(user);
			if (result != null) {
				response = "success";
			} else {
				response = "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception from Database");
			e.printStackTrace();
		}
		
		return response;
	}

}
