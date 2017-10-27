package com.musicBonanza.business;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.musicBonanza.dao.ProductCategoriesDao;
import com.musicBonanza.entity.PurchaseOrder;
import com.musicBonanza.entity.Shipping;
import com.musicBonanza.entity.User;

public class ProductCategoryManager {

	public String getCategoryList(String category) throws IOException, SQLException {
		ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();

		String response = null;
		ResultSet resultSet = productCategoriesDao.getCategoryList(category);
		try {
			if (resultSet != null) {
				
				  while(resultSet.next()) {
				  
				  String resultCategory = resultSet.getString("category");
				  System.out.println(resultCategory); }
				 
				response = "Success";

			}
			else
			{
				response = "Failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}