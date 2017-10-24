package com.musicBonanza.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class LoginDBManager {
	private Connection connection;
	public void initConnectionPool(){
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/myDataSource");
			connection = ds.getConnection();
			System.out.println(connection);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet login(String query, List<String> parameters){
		query += "username = "+parameters.get(0)+ " AND passowrd = "+parameters.get(1);
		ResultSet resultSet = null;
		try {
			//PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
