package com.musicBonanza.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class LoginDao {
	LoginDBManager loginDBManager;
	Properties prop = new Properties();
	InputStream input = null;
	
	public LoginDao(){
		loginDBManager = new LoginDBManager();
	}
	public String login(List<String> parameters) throws IOException{
		input = new FileInputStream("D:/Fall 2017/Projects/MusicBonanza/src/com/musicBonanza/Util/sqlQuery.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		String query = prop.getProperty("selectFromUserLogin");
		ResultSet resultSet = loginDBManager.login(query, parameters);
		try {
			if(resultSet.next()){
				return "success";
			}
			else{
				return "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}
}
