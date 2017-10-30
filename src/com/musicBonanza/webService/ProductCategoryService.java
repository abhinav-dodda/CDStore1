package com.musicBonanza.webService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.musicBonanza.business.*;
import com.musicBonanza.entity.ProductCategories;
/***
 * 
 * @author nappa086
 *ProductCategoryService Class with 3 methods:
 *getCategoryList: This method retrieves all category types from Manager
 *				   Parameters: N/A
 *getProductList:  This method retrives all products based on the selected category on Product Categories page
 *				   Parameters: String (JSON String with the selected category value)
 *getProductInfo:  This method retrives details of a selected product on Product Categories page
 *				   Parameters: String (JSON String with the selected product id (hidden tag in Product Categories page)
 */
@Path("/ProductCategory")
public class ProductCategoryService {

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryList() throws IOException {
		ResultSet result = null;
		JSONArray jsonArray = new JSONArray();

		String output;

		try {
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			result = productCategoryManager.getCategoryList();

			int key = 0;

			while (result.next()) {
				JSONObject jsonObject = new JSONObject();
				output = result.getString("category");
				jsonObject.put("category", output);

				jsonArray.add(key++, jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonArray.toJSONString();
	}

	@POST
	@Path("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductList(String parms) throws IOException {
		ResultSet result = null;
		ProductCategories productCategories = new ProductCategories();

		JSONArray jsonArray = new JSONArray();

		try {
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			result = productCategoryManager.getProductList(productCategories);

			int key = 0;

			while (result.next()) {
				JSONObject jsonObject = new JSONObject();

				String Cdid = result.getString("cdid");
				jsonObject.put("cdid", Cdid);

				String Title = result.getString("title");
				jsonObject.put("title", Title);

				Float Price = result.getFloat("price");
				jsonObject.put("price", Price);

				String Category = result.getString("category");
				jsonObject.put("category", Category);

				jsonArray.add(key++, jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonArray.toJSONString();
	}
	
	@POST
	@Path("/details")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductInfo(String parms) throws IOException {
		ResultSet result = null;
		JSONArray jsonArray = new JSONArray();

		try {
			ProductCategoryManager productCategoryManager = new ProductCategoryManager();
			result = productCategoryManager.getProductInfo(parms);

			int key = 0;

			while (result.next()) {
				JSONObject jsonObject = new JSONObject();

				String cdid = result.getString("cdid");
				jsonObject.put("cdid", cdid);

				String title = result.getString("title");
				jsonObject.put("title", title);

				String artist = result.getString("artistName");
				jsonObject.put("price", artist);

				String releaseDate = result.getString("releaseDate");
				jsonObject.put("category", releaseDate);


				String producer = result.getString("producer");
				jsonObject.put("price", producer);

				String awards = result.getString("awards");
				jsonObject.put("category", awards);
				
				String category = result.getString("category");
				jsonObject.put("category", category);
				
				jsonArray.add(key++, jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonArray.toJSONString();
	}
}