package com.musicBonanza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;
 
// Data Access Object for Order Processing

public class OrderProcessDao {
      
	// Method to Get Account information from the database
	
	public User getAccount(String username,String password) throws SQLException{
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(username);
		parameters.add(password);
		
		// executing SQL Query to get results
		
		ResultSet resultSet ;
		User user = null;
		resultSet = DBManager.getQueryResult("selectFromUserDetails", parameters);
		if(resultSet.next()){
			user = new User();
			user.setEmail(resultSet.getString("email"));
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setUsername(resultSet.getString("username"));
		}
		return user;
		}
	
	public User getAccountByUsername(String username) throws SQLException{
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(username);
		
		// executing SQL Query to get results
		
		ResultSet resultSet ;
		User user = null;
		resultSet = DBManager.getQueryResult("selectUserByUsername", parameters);
		if(resultSet.next()){
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
	
	public Result createAccount(User user) throws SQLException{
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getUsername());
		parameters.add(user.getFirstName());
		parameters.add(user.getLastName());
		parameters.add(user.getPassword());
		parameters.add(user.getEmail());
	
		// executing SQL query to insert user information in the database
		
		Result result;
		result = DBManager.executeSQL("insertIntoUser", parameters);
		return result;
	}
	
	public Shipping getShippingById(int shippingId) throws SQLException{
		List<String> parameters = new ArrayList<String>();
		parameters.add(""+shippingId);
		Shipping shipping = null;
		ResultSet resultSet = DBManager.getQueryResult("seletAddressById", parameters);
		if(resultSet.next()){
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

}
