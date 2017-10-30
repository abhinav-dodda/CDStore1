package com.musicBonanza.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.musicBonanza.Helper.Helper;
import com.musicBonanza.entity.ProductCategories;
import com.musicBonanza.utils.Constants;

public class ProductCategoriesDao {
	Properties prop = new Properties();

	public ProductCategoriesDao() {

	}

	public ResultSet getCategoryList() throws IOException, SQLException {
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);

		List<String> parameters = new ArrayList<String>();
		ResultSet resultSet=null;
		try {
			resultSet = DBAgent.getQueryResult("selectCategoryFromProductCategories", parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//.getQueryResult("selectCategoryFromProductCategories", parameters);
		return resultSet;
	}
	
	public ResultSet getProductList(ProductCategories productCategory) throws IOException, SQLException
	{
		ResultSet resultSet=null;
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		List<String> parameters = new ArrayList<String>();
		
		if(productCategory.getCategoryName() == "All") {
			try {
				resultSet = DBAgent.getQueryResult("selectAllProducts", parameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			parameters.add(productCategory.getCategoryName());
			try {
				resultSet = DBAgent.getQueryResult("selectProductsWhereCategory", parameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return resultSet;
	}
	
	public ResultSet getProductInfo(String parms) throws IOException, SQLException
	{
		ResultSet resultSet=null;
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		List<String> parameters = new ArrayList<String>();
		
		parameters.add(parms);
		try {
			resultSet = DBAgent.getQueryResult("selectProductDetailsWhereCdid", parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}