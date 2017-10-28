package com.musicBonanza.webService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
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
import com.musicBonanza.entity.ProductCategories;
import com.mysql.jdbc.PreparedStatement;


@Path("/ProductCategory") 
public class ProductCategoryService {
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getCategoryList() throws IOException
	{
		ResultSet result = null;
		ProductCategories productCategories = new ProductCategories();
		
		JSONArray jsonArray = new JSONArray();

		String output;
		
		try 
		{
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			result = productCategoryManager.getCategoryList();
			// productCategories.setCategoryName(result.getString("category"));
			 
			int key=0;
			
			
			while(result.next())
			{
				JSONObject jsonObject = new JSONObject();
				output = result.getString("category");
				jsonObject.put("category", output);
				
				jsonArray.add(key++, jsonObject);
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonArray.toJSONString();
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