package com.musicBonanza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.User;
 
// Data Access Object for Order Processing

public class OrderProcessDao {
      
	// Method to Get Account information from the database
	
	public ResultSet getAccount(User user) throws SQLException{
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getUsername());
		parameters.add(user.getPassword());
		
		// executing SQL Query to get results
		
		ResultSet resultSet ;
		resultSet = DBManager.getQueryResult("selectFromUserLogin", parameters);
		return resultSet;
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

}
