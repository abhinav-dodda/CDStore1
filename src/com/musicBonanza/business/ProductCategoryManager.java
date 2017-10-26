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
	
	public String getProductCategories(String category) throws IOException{
		ProductCategoriesDao productCategoriesDao = new ProductCategoriesDao();
		String response = null;

		ResultSet resultSet = productCategoriesDao.getProducts(category);
try {
		if(resultSet!=null) 
		{
			while(resultSet.next()) 
			{

					String title = resultSet.getString("title");
					System.out.println(title);
			}
			
			response = "success";
		}
		else {
			response = "failure";
		}
}
catch(Exception e)
{
	e.printStackTrace();
	}
		
		return response;
		}
}