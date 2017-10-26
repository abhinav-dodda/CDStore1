package com.musicBonanza.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.musicBonanza.utils.Constants;

import java.sql.ResultSet;

public class ProductCategoryDBManager {
	private Connection connection;

	public void initConnectionPool() 
	{
		try 
		{
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(Constants.envNameContext);
			connection = ds.getConnection();
			System.out.println(connection);
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet productCategories(String query, String category) 
	{
		query += "category = " + category;
		ResultSet resultSet = null;
		try 
		{
			// PreparedStatement preparedStatement = (PreparedStatement)
			// connection.prepareStatement(query);
			this.initConnectionPool();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
}
