package com.musicBonanza.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicBonanza.dao.OrderProcessDao;
import com.musicBonanza.dao.PurchaseOrderDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;

// Business layer logic for Order Process Service 

public class OrderProcessManager {

	/*
	 * Method to get user account information and checking if result is received
	 * from database then return success otherwise failure
	 * 
	 * @param user
	 * 
	 * @return response
	 */

	public User getAccount(String username, String password) throws SQLException {
		String response = null;
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		User user = orderProcessDao.getAccount(username, password);

		// checking response from database
		if (user != null) {
			if (user.getUsername().equals(username)) {
				response = "success";
			} else {
				response = "failure";
			}
		}
		return user;
	}

	/*
	 * Method to get user account information based on usrename and checking if
	 * result is received from database then return success otherwise failure
	 * 
	 * @param user
	 * 
	 * @return response
	 */

	public User getAccountByUsername(String username) {
		User user = null;
		try {
			OrderProcessDao orderProcessDao = new OrderProcessDao();
			user = orderProcessDao.getAccountByUsername(username);

			// checking response from database
			if (user == null) {
				System.out.println("No details found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception from Database");
			e.printStackTrace();
		}

		return user;
	}

	/*
	 * Method for creating new account and checking response from the database
	 * 
	 * @param user
	 * 
	 * @return response
	 */

	public String createAccount(User user) {
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		String response = null;
		try {
			int rowNum = orderProcessDao.createAccount(user);

			// checking response from the database

			if (rowNum != 0) {
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

	public Shipping getShippingById(int shippingId) {
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		Shipping shipping = null;
		try {
			shipping = orderProcessDao.getShippingById(shippingId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception from Database");
			e.printStackTrace();
		}
		return shipping;
	}

	/*
	 * Method for creating new shipping address
	 * 
	 * @param user
	 * 
	 * @return response
	 */

	public int createShipping(Shipping shipping) {
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		int shippingId = orderProcessDao.createShipping(shipping);
		return shippingId;
	}

	public String updateUserShipping(User user) {
		String response = null;
		OrderProcessDao orderProcessDao = new OrderProcessDao();
		int rowNum = orderProcessDao.updateUserShipping(user);
		if (rowNum != 0) {
			response = "success";
		} else {
			response = "failure";
		}
		return response;
	}

}
