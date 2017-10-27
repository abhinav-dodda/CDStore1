package com.musicBonanza.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.musicBonanza.Helper.Helper;
import com.musicBonanza.utils.Constants;

public class ProductCategoriesDao 
{
/*	ProductCategoryDBManager productCategoryDBManager = new ProductCategoryDBManager();;*/
	Properties prop = new Properties();
	
	public ProductCategoriesDao()
	{
		
	}
	
	public ResultSet getCategoryList() throws IOException, SQLException
	{
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
/*		List<String> parameters = new ArrayList<String>();
		parameters.add(category);*/
		List<String> parameters = new ArrayList<String>();
		ResultSet resultSet = DBManager.getQueryResult("selectCategoryFromProductCategories", parameters);
		return resultSet;
		}
		/*String query = propertyObj.getProperty("selectCategoryFromProductCategories");
		ResultSet resultSet = productCategoryDBManager.productCategories(query, category);
		
		//ResultSet resultSet = DBManager.runSQLQueries("selectFromProductCategories", parameters);
		return resultSet;*/
		// get the property value and print it out
		/*String query = propertyObj.getProperty("selectFromProductCategories");
		ResultSet resultSet = productCategoryDBManager.productCategories(query, category);
		
		try {
			if(resultSet.next()){
				return resultSet.getString("title");
			}
			else{
				return "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";*/
	}

