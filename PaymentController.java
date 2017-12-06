package com.simplify.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplify.model.CustomerData;
import com.simplify.payments.exception.ApiCommunicationException;
import com.simplify.payments.exception.AuthenticationException;
import com.simplify.payments.exception.InvalidRequestException;
import com.simplify.payments.exception.NotAllowedException;
import com.simplify.payments.exception.SystemException;
import com.simplify.service.PaymentService;

@WebServlet("/payment")
public class PaymentController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267373237428434244L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String token =req.getParameter("simplifyToken");
		PaymentService paymentService = new PaymentService();		
		 resp.setContentType("text/html");
		try {
			String retVal = paymentService.payAmount(1000, "Payment description", CustomerData.getCustIds().get(0));
			RequestDispatcher rs = req.getRequestDispatcher("ecomerce.html");
	        rs.forward(req, resp);
		} catch (ApiCommunicationException | AuthenticationException
				| InvalidRequestException | NotAllowedException
				| SystemException e) {
			
		}
       
	}
	
	

}
