package com.musicBonanza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musicBonanza.entity.CD;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProductCategories
 */
@WebServlet("/ProductCategories")
public class ProductCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCategories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("servlet is called");
		String[] productName = {"Naanum Rowdy Dhaan", "OK Kanmani", "AR Rahuman Mashups"};
		String[] productId = {"cd001", "cd002", "cd003"};
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
		System.out.println(cart.get(i));
		//cart.add(usercart);
		}
		session.setAttribute("cart",cart);
		
		//forward the request back to product page
		 request.getRequestDispatcher("ProductCategories.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
