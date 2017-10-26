package com.musicBonanza.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.musicBonanza.*;
import com.musicBonanza.Helper.Helper;
import com.musicBonanza.entity.Result;
import com.musicBonanza.entity.User;
import com.musicBonanza.utils.Constants;

public class OrderProcessDao {

	public ResultSet getAccount(String userName, String password) throws IOException {
		//String response = orderProcessDao.getAccount(userName,password);
		List<String> parameters = new ArrayList<String>();
		parameters.add(userName);
		parameters.add(password);
		
		ResultSet resultSet = DBManager.getQueryResult("selectFromUserLogin", parameters);
		return resultSet;
		}
	
	public Result createAccount(User user) throws IOException{
		List<String> parameters = new ArrayList<String>();
		parameters.add(user.getSignupname());
		parameters.add(user.getUserName());
		parameters.add(user.getsignupEmail());
		parameters.add(user.getsignupPassword());
		parameters.add(user.getConfirmsignupPassword());
		DBManager dbManager= new DBManager();
		Result result = dbManager.executeSQL("InsertIntoUsers", parameters);
		return result;
	}

}
