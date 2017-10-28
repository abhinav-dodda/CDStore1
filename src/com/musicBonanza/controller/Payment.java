package com.musicBonanza.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

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
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*method for payment in confirm order 
	@param request
	@param response
	@throw servletException
	@throw IOException*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          // Retrieving data from Payment.jsp
		
		String cardHolderName = request.getParameter("holder_name");
		String cardNumber = request.getParameter("card_number");
		String expiryDate= request.getParameter("expiry_date");
		String cardCVV = request.getParameter("card_cvv");
		
		// Calling Web Service to process payment
		
				Client client = Client.create();
				WebResource webResource = client.resource(Constants.localhostUrl+"orderProcess/confirmOrder");
		        String input = "{\"cardHolderName\":\""+cardHolderName+"\",\"cardNumber\":\""+cardNumber+"\","+
		        		"\"expiryDate\":\""+expiryDate+"\",\"cardCVV\":\""+cardCVV+"\"}";
		        ClientResponse webServiceResponse = webResource.type("application/json")
		           .post(ClientResponse.class, input);
		
		        int responseCode = webServiceResponse.getStatus();
				System.out.println("POST Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					response.sendRedirect("home.jsp");
					/*BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}*/
					//in.close();

					// print result
					//System.out.println(response.toString());
				} else {
					
					System.out.println("POST request not worked");
				}
	}

}
