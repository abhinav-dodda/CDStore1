package com.musicBonanza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.PurchaseOrderItem;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;

// Data Access Object for Order Processing

public class OrderProcessDao {

	// Method to Get Account information from the database

	public User getAccount(String username, String password) throws Exception {
		// String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(username);
		parameters.add(password);

		// executing SQL Query to get results

		ResultSet resultSet;
		User user = null;
		resultSet = DBManager.getQueryResult("selectFromUserDetails", parameters);
		if (resultSet.next()) {
			user = new User();
			user.setEmail(resultSet.getString("email"));
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setUsername(resultSet.getString("username"));
		}
		return user;
	}

	public User getAccountByUsername(String username) throws Exception {
		// String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(username);

		// executing SQL Query to get results

		ResultSet resultSet;
		User user = null;
		resultSet = DBManager.getQueryResult("selectUserByUsername", parameters);
		if (resultSet.next()) {
			user = new User();
			user.setEmail(resultSet.getString("email"));
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setUsername(resultSet.getString("username"));
			user.setShippingId(resultSet.getInt("shippingid"));
		}
		return user;
	}

	// Method to Create Account and storing information in the database

	public int createAccount(User user) throws Exception {
		int rowNum = 0;
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getUsername());
		parameters.add(user.getFirstName());
		parameters.add(user.getLastName());
		parameters.add(user.getPassword());
		parameters.add(user.getEmail());

		// executing SQL query to insert user information in the database
		rowNum = DBManager.executeSQL("insertIntoUser", parameters);
		return rowNum;
	}

	public Shipping getShippingById(int shippingId) throws Exception {
		List<String> parameters = new ArrayList<String>();
		parameters.add("" + shippingId);
		Shipping shipping = null;
		ResultSet resultSet = DBManager.getQueryResult("seletAddressById", parameters);
		if (resultSet.next()) {
			shipping = new Shipping();
			shipping.setCountry(resultSet.getString("country"));
			shipping.setPhone(resultSet.getString("phone"));
			shipping.setProvince(resultSet.getString("province"));
			shipping.setShippingId(shippingId);
			shipping.setStreetAddress(resultSet.getString("street"));
			shipping.setZipCode(resultSet.getString("zip"));
		}
		return shipping;
	}

	public int createShipping(Shipping shipping) throws Exception {
		int insertRowId = 0;
		try {
			// insert into address
			List<String> parameters = new ArrayList<>();
			parameters.add(shipping.getStreetAddress());
			parameters.add(shipping.getProvince());
			parameters.add(shipping.getCountry());
			parameters.add(shipping.getZipCode());
			parameters.add(shipping.getPhone());
			insertRowId = DBManager.executePreparedSQL("insertIntoAddress", parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Constants.dataNotSaved);
		}
		if (0 != insertRowId) {
			System.out.println(Constants.dataSaved);
		} else {
			System.out.println(Constants.dataNotSaved);
		}
		return insertRowId;
	}

	public int updateUserShipping(User user) throws Exception {
		int rowNum = 0;
		try {
			List<String> parameters = new ArrayList<String>();
			parameters.add("" + user.getShippingId());
			parameters.add(user.getUsername());

			// executing SQL query to insert user information in the database
			rowNum = DBManager.executeSQL("updateUserDetailsWithAddressId", parameters);
			if(rowNum == 0){
				System.out.println(Constants.dataNotSaved);
			}
			else{
				System.out.println(Constants.dataSaved);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Constants.dataNotSaved);
		}
		return rowNum;
	}

}
