package com.musicBonanza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.User;

public class OrderProcessDao {

	public ResultSet getAccount(User user) throws SQLException{
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getUsername());
		parameters.add(user.getPassword());
		ResultSet resultSet ;
		resultSet = DBManager.getQueryResult("selectFromUserLogin", parameters);
		return resultSet;
		}
	
	public Result createAccount(User user) throws SQLException{
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getUsername());
		parameters.add(user.getFirstName());
		parameters.add(user.getLastName());
		parameters.add(user.getPassword());
		parameters.add(user.getEmail());
		Result result;
		result = DBManager.executeSQL("insertIntoUser", parameters);
		return result;
	}

}
