package com.musicBonanza.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.musicBonanza.entity.CD;
import com.musicBonanza.entity.CD.*;




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
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("buy"))
		{
			doGet_Purchase(request, response);
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			doGet_delete(request, response);
		}
		else if(action.equalsIgnoreCase("checkout")) 
		{
			doGet_checkout(request, response);
		}
	}
 // Purchase Order action
	protected void doGet_Purchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  HttpSession session = request.getSession();	
      CD cdCart = new CD();// add constructor arguments - naveen
      if(session == null)
      {
    	 List<CD> cart = new ArrayList<CD>();
    	 cart.add(new CD(productId, productName, prodPrice, prodDesc, imgUrl));//declare variables 
    	 session.setAttribute("cart", cart);
    	 //naveen session set attribute
    	 PurchaseOrder purchaseOrder = new PurchaseOrder();
     	 session.setAttribute("cart",purchaseOrder);
     	 User cart =  (User) session.getAttribute("cart");
      }
      else
      {
    	  List<CD> cart = (List<CD>) session.getAttribute("cart");
      }
    	request.getRequestDispatcher("Cart.jsp").forward(request, response);  
	}
	//delete action for shopping cart
	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    int id = Integer.parseInt(request.getParameter("index"));
	    HttpSession session = request.getSession();	
	    List<CD> cart = (List<CD>) session.getAttribute("cart");
	    cart.remove(index);
	    session.setAttribute("cart",cart);
	    response.sendRedirect("Cart.jsp");
        
	}
	
	//check out order action
	
	protected void doGet_checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    int id = Integer.parseInt(request.getParameter("index"));
	    HttpSession session = request.getSession();	
	    List<CD> cart = (List<CD>) session.getAttribute("cart");
        //gurpreet will continue
        
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
