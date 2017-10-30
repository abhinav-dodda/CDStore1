package com.musicBonanza.business;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicBonanza.dao.ProductCategoriesDao;
import com.musicBonanza.entity.ProductCategories;

public class ProductCategoryManager {

	public ResultSet getCategoryList() throws IOException, SQLException {
		ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();

		String response = null;
		ResultSet resultSet = productCategoriesDao.getCategoryList();
		try {
			if (resultSet != null) {

				return resultSet;
			} else {
				response = "Failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet getProductList(ProductCategories productCategory) throws IOException, SQLException{
		
		ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();

		String response = null;
		ResultSet resultSet = productCategoriesDao.getProductList(productCategory);
		try {
			if (resultSet != null) {
				return resultSet;
			} else {
				response = "Failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet getProductInfo(String parms) throws IOException, SQLException{
		
		ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();

		String response = null;
		ResultSet resultSet = productCategoriesDao.getProductInfo(parms);
		try {
			if (resultSet != null) {
				return resultSet;
			} else {
				response = "Failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}