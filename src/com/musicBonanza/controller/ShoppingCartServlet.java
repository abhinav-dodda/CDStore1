package com.musicBonanza.controller;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musicBonanza.entity.CD;
import com.sun.jersey.spi.dispatch.RequestDispatcher;


/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //Nandhini: created to update/delete the cart details  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("delete"))
		{
			doGet_delete(request, response);
		}
		else if(action.equalsIgnoreCase("update")) 
		{
			doGet_updateQuantity(request, response);
		}
		else if(action.equalsIgnoreCase("checkout")) 
		{
			
			doGet_checkout(request, response);
		}
	}

	//Nandhini: Handles the delete part of shopping cart
	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(request.getParameter("prodId") != null || session.getAttribute("cart") != null)
		{
    	String prodId = request.getParameter("prodId");
    	List<CD> cart = (List<CD>) session.getAttribute("cart");
    	Iterator<CD> iter = cart.iterator();
    	while (iter.hasNext()) 
    	{
    		CD usercart = iter.next();
    		if(usercart.getProductId().equals(prodId))
    		{
    			iter.remove();
    		}
    	}
	   }
    	response.sendRedirect("Cart.jsp");
	 }
	
	//Nandhini: update quantity in the cart and price
	protected void doGet_updateQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		float priceupdate = 0;
		float reducedprice = 0;
		float actualprice = 0;
		float price;
		float quantity;
		float totalprice = 0; 
		HttpSession session = request.getSession();
		
		if(request.getParameter("price") != null || request.getParameter("selectQuantity") != null || session.getAttribute("totalPrice") != null)
		{
	        price  = Float.parseFloat(request.getParameter("price"));
		    quantity = Float.parseFloat(request.getParameter("selectQuantity"));
		    totalprice = (float) session.getAttribute("totalPrice");
			priceupdate = price*quantity;
			reducedprice = totalprice - price;
			actualprice = reducedprice + priceupdate;
			session.setAttribute("totalPrice",actualprice);
			response.sendRedirect("Cart.jsp");
		}
 
	 }
	
	//Nandhini: directing the further task to check out order action
	protected void doGet_checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		request.getRequestDispatcher("OrderCheckOut").forward(request,response);
        
	}
 	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		
	}

}
