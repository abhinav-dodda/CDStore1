package com.musicBonanza.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.musicBonanza.Helper.Helper;
import com.musicBonanza.utils.Constants;

public class ProductCategoriesDao 
{
	ProductCategoryDBManager productCategoryDBManager = new ProductCategoryDBManager();;
	Properties prop = new Properties();
	
	public ProductCategoriesDao()
	{
		
	}
	
	public String getProducts(String category) throws IOException
	{
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		
		// get the property value and print it out
		String query = propertyObj.getProperty("selectFromProductCategories");
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
		return "failure";
	}
}
