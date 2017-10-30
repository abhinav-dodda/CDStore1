package com.musicBonanza.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class ProductCategory
 */

/**
 * 
 * @author nappa086
 * Servlet Path: ProductCategoryServlet
 * doGet Method is used to retrieve categories using getCategoriesList web service method and bind Combo Box on Product Catalog page
 * doPost Method is used to retrieve Products  using getProductList web service method 
 * and retrieve the details using getProductInfo web service method for a selected product
 *
 */
@WebServlet("/ProductCategoryServlet")
public class ProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public ProductCategory() 
	{
		super();
	}

	/**
	 * doGet method
	 * Parameters: HttpServletRequest, HttpServletResponse
	 * Possible Exceptions: ServletException, IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		/**
		 * Using Jersy client, access the web service "categories" which invokes getCategoriesList() 
		 */
		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl + "ProductCategory/categories");
		ClientResponse webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		/**
		 * Verify the response code is matching with HTTP_OK 
		 */
		int responseCode = webServiceResponse.getStatus();

		if (responseCode == HttpURLConnection.HTTP_OK) 
		{
			String output = webServiceResponse.getEntity(String.class);
			JSONParser parser = new JSONParser();
			try 
			{
				/**
				 * Parse the output of type JSONString to JSONArray
				 */
				JSONArray json = (JSONArray) parser.parse(output);

				/**
				 * Set category attribute with json array
				 * Using RequestDispatcher forward the category to ProductCategories.jsp
				 */
				request.setAttribute("category", json);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductCategories.jsp");
				rd.forward(request, response);
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("GET request not worked");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	/**
	 * doPost method
	 * Parameters: HttpServletRequest, HttpServletResponse
	 * Possible Exceptions: ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String cdid = request.getParameter("cdid");
		String category = request.getParameter("selectCategory");

		if (!category.isEmpty()) 
		{
			/**
			 * Using Jersy client, access the web service "products" which invokes getProductList() 
			 */
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "ProductCategory/products");
			//Convert Parameters into Json format 
			String input = "{\"category\":\"" + category + "\"}";
			ClientResponse webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

			/**
			 * Verify the response code is matching with HTTP_OK 
			 */
			int responseCode = webServiceResponse.getStatus();
			System.out.println("POST Response Code :: " + responseCode); //################################### REMOVE THIS #############################

			if (responseCode == HttpURLConnection.HTTP_OK) 
			{
				String output = webServiceResponse.getEntity(String.class);
				JSONParser parser = new JSONParser();
				try {
					JSONArray json = (JSONArray) parser.parse(output);

					/**
					 * Parse the output of type JSONString to JSONArray
					 */
					request.setAttribute("cdid", json);
					request.setAttribute("title", json);
					request.setAttribute("price", json);
					request.setAttribute("category", json);
					
					/**
					 * Set category attribute with json array
					 * Using RequestDispatcher forward the category to ProductCategories.jsp
					 */
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductCategories.jsp");
					rd.forward(request, response);
					System.out.println(output.toString()); //################################### REMOVE THIS #############################
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				}

			} 
			else 
			{
				System.out.println("GET request not worked");
			}

		}
		else
		{
			//Redirecting to Product Catalog page
			response.sendRedirect("/ProductCategories.jsp");
		}

		if (!cdid.isEmpty()) 
		{
			/**
			 * Using Jersy client, access the web service "details" which invokes getProductInfo() 
			 */
			Client client = Client.create();
			WebResource webResource = client.resource(Constants.localhostUrl + "ProductCategory/details");
			//Convert Parameters into Json format 
			String input = "{\"cdid\":\"" + cdid + "\"}";
			ClientResponse webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
			
			/**
			 * Verify the response code is matching with HTTP_OK 
			 */
			int responseCode = webServiceResponse.getStatus();
			
			System.out.println("POST Response Code :: " + responseCode);  //################################### REMOVE THIS #############################

			if (responseCode == HttpURLConnection.HTTP_OK) 
			{
				String output = webServiceResponse.getEntity(String.class);
				JSONParser parser = new JSONParser();
				try 
				{
					JSONArray json = (JSONArray) parser.parse(output);

					/**
					 * Parse the output of type JSONString to JSONArray
					 */
					request.setAttribute("cdid", json);
					request.setAttribute("title", json);
					request.setAttribute("artistName", json);
					request.setAttribute("releaseDate", json);
					request.setAttribute("producer", json);
					request.setAttribute("awards", json);
					request.setAttribute("category", json);
					
					/**
					 * Set category attribute with json array
					 * Using RequestDispatcher forward the category to ProductCategories.jsp
					 */
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductCategories.jsp");
					rd.forward(request, response);
					
					System.out.println(output.toString()); //################################### REMOVE THIS #############################
				}
				catch (ParseException e) 
				{
					e.printStackTrace();
				}

			} 
			else 
			{
				System.out.println("POST request not worked");
			}

		}
		else
		{
			//Redirecting to Product Catalog page
			response.sendRedirect("/ProductCategories.jsp");
		}
	}

}