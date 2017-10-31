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
  //GET method for shopping cart  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
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
			System.out.println("heyllooooo check out");
			doGet_checkout(request, response);
		}
	}

	//delete action for shopping cart
	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
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
    	response.sendRedirect("Cart.jsp");
	 }
	
	//update quantity in the cart and price
	protected void doGet_updateQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//HttpSession session = request.getSession();
		String prodId = request.getParameter("prodId");
		String price = request.getParameter("price");
		String quantity = request.getParameter("selectQuantity");
		System.out.println("ProductId:"+prodId);
		System.out.println("prodPrice:"+price);
		System.out.println("quantity:"+quantity);
		
    	//String prodId = request.getParameter("prodId");
    	//String prodPrice = request.getParameter("price");
    	//String totalprice = request.getParameter("totalPrice");
    	//int quantity = quantity.getText();
    	//System.out.println("ProductId:"+prodId);
    	//System.out.println("totalprice:"+totalprice);
    	//System.out.println("prodPrice:"+prodPrice);
 
	 }
	
	//check out order action
	protected void doGet_checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String totalprice = request.getParameter("totalPrice");
		request.setAttribute("totalprice", totalprice);
		System.out.println("check:"+request.getAttribute("totalprice"));
		System.out.println("check:"+totalprice);
		request.getRequestDispatcher("OrderCheckOut").forward(request,response);
        
	}
 	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
