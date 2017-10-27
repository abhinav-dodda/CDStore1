package com.musicBonanza.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		Client client = Client.create();
		WebResource webResource = client.resource(Constants.localhostUrl + "ProductCategory/categories");
		ClientResponse webServiceResponse = webResource.type("application/json").get(ClientResponse.class);

		request.setAttribute("category", category);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductCategories.jsp");
	    rd.forward(request, response);
		
		int responseCode = webServiceResponse.getStatus();
		
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			System.out.print(response);
			//response.sendRedirect("ProductCategory.jsp");

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