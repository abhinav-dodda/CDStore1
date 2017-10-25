package com.musicBonanza.webService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


import com.musicBonanza.business.*;
import com.musicBonanza.dao.ProductCategoriesDao;
import com.musicBonanza.dao.ProductCategoryDBManager;
import com.mysql.jdbc.PreparedStatement;
@Path("/ProductCategory") 

public class ProductCategoryService {
	//ProductCategoryManager productCategoryManager = new ProductCategoryManager();
	
	
	@GET
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String categories() throws IOException
	{
		/*ProductCategoryDBManager productCategoryManager = new ProductCategoryDBManager();
		String output = productCategoryManager.productCategories();*/
		ProductCategoriesDao productCategoryDao = new ProductCategoriesDao();
		String x = productCategoryDao.getProducts("POP");
		System.out.println(x);
		
		return x;
	}
}
