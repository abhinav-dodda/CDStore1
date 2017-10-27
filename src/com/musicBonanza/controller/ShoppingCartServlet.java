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
		
		HttpSession session = request.getSession();
		
		if(session == null)
		{
			System.out.println("session isssssss null");
			response.sendRedirect("Cart.jsp");	
		}
    	String action = request.getParameter("action");
		if(action != null)
		{
			if(action.equalsIgnoreCase("delete"))
			{
				doGet_delete(request, response);
			}
			else if(action.equalsIgnoreCase("checkout")) 
			{
				doGet_checkout(request, response);
			}
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
	
	//check out order action
	
	protected void doGet_checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

        
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
