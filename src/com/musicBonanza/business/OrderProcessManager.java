package com.musicBonanza.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.User;

// Business layer logic for Order Process Service 

public class OrderProcessManager {

	/*Method to get user account information and checking if result
    * is received from database then return success otherwise failure
	@param user
	@return response*/
	
	public String getAccount(User user){
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		ResultSet resultSet;
		try {
			resultSet = orderProcessDao.getAccount(user);
			
			//checking response from database
			
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

	/*Method for creating new account and checking response from the database 
	@param user
	@return response*/
	
	public String createAccount(User user) {
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		try {
			Result result = orderProcessDao.createAccount(user);
		
			//checking response from the database
			
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
