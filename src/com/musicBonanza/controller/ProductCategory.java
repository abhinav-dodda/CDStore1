package com.musicBonanza.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import com.musicBonanza.entity.CD;
import com.musicBonanza.utils.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Servlet implementation class ProductCategory
 */
@WebServlet("/ProductCategoryServlet")
public class ProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl+"ProductCategory/categories");
        ClientResponse webServiceResponse = webResource.type("application/json")
           .get(ClientResponse.class);
        		
		int responseCode = webServiceResponse.getStatus();
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			response.sendRedirect("ProductCategories.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}*/
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub

	}











/*
*//**
 * Servlet implementation class ProductCategory
 *//*
@WebServlet("/ProductCategoryServlet")
public class ProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("selectCategory");
        //Naveen yet to get product details from DB for cart session
		
		//Nandhini : created to get the product details to set the session attribute
		
		String[] productName = {"Naanum Rowdy Dhaan", "OK Kanmani", "AR Rahuman Mashups"};
		String[] productId = {"product-1", "product-2", "product-3"};
		String[] prodCat = {"Tamil", "Multilingual", "Regional"};
		float[] prodPrice = {45, 55, 105};
		int size = productId.length;
		HttpSession session = request.getSession();
		List<CD> cart = new ArrayList<CD>();
		//pass the parameter to the class and set the array list values
		for (int i = 0; i < size; i++)
		{
		CD usercart = new CD();
		usercart.setProductId(productId[i]);
		usercart.setProductName(productName[i]);
		usercart.setProdCat(prodCat[i]);
		usercart.setProdPrice(prodPrice[i]);
		//store it in the Arraylist	
		cart.add(usercart);
		//cart.add(i, usercart);
		//System.out.println(cart.get(i));  
		//cart.add(usercart);
		}
		session.setAttribute("cart",cart);
		
		
	   //forward the request back to product page
	   //request.getRequestDispatcher("ProductCategories.jsp").forward(request, response);
		 
	   //Nandhini :end of the code
		 
		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl + "ProductCategory");
		ClientResponse webServiceResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		int responseCode = webServiceResponse.getStatus();
		Client aa = webServiceResponse.getClient();
		
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			System.out.println(category);
			System.out.print(aa);
			request.setAttribute("category", category);
			String output = webServiceResponse.getEntity(String.class);
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductCategories.jsp");
		    rd.forward(request, response);
		    System.out.println(output);

		} else {
			System.out.println("POST request not worked");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		// TODO Auto-generated method stub

	}

}
*/