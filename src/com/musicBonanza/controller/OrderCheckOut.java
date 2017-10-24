package com.musicBonanza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderCheckOut")
public class OrderCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Get details of logged customer from session
		boolean logged = false;
		if(!logged){
			String message = "Please login to place order";
			//redirect to Login jsp
		}
		else{
			//
		}
	
	}
}
