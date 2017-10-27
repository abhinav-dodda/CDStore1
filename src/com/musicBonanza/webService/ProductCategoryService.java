package com.musicBonanza.webService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


import com.musicBonanza.business.*;
import com.musicBonanza.dao.ProductCategoriesDao;
import com.mysql.jdbc.PreparedStatement;


@Path("/ProductCategory") 
public class ProductCategoryService {
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryList() throws IOException
	{
		String response = null;
		try 
		{
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			
			String result = productCategoryManager.getCategoryList("category");
			/*while(resultSet.next())
			{
				response = resultSet.getString("category");
			}*/
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}






































/*
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


import com.musicBonanza.business.*;
import com.musicBonanza.dao.ProductCategoriesDao;
import com.mysql.jdbc.PreparedStatement;

@Path("/ProductCategory") 
public class ProductCategoryService {
	//ProductCategoryManager productCategoryManager = new ProductCategoryManager();
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryList() throws IOException
	{
		String response = "failure";
		
		try 
		{
			
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			//System.out.println(params);
			ResultSet resultSet = productCategoryManager.getCategoryList("category");
			while(resultSet.next())
			{
				response = resultSet.getString("category");
			}
			if(resultSet.next()) {
				response = "success";
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}
*/