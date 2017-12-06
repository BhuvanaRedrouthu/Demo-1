package com.simplify.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplify.payments.exception.ApiCommunicationException;
import com.simplify.payments.exception.AuthenticationException;
import com.simplify.payments.exception.InvalidRequestException;
import com.simplify.payments.exception.NotAllowedException;
import com.simplify.payments.exception.SystemException;
import com.simplify.service.CustomerService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8201059842560295490L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		int expMonth = Integer.parseInt(req.getParameter("cc-exp-month"));
		int expYear = Integer.parseInt(req.getParameter("cc-exp-year"));
		int cvc = Integer.parseInt(req.getParameter("cc-cvc"));
		long cardNumber = Long.parseLong(req.getParameter("cc-number"));
		try {
			new CustomerService().registerCustomer(email, name, cardNumber, expMonth, expYear, cvc);
		} catch (ApiCommunicationException | AuthenticationException
				| InvalidRequestException | NotAllowedException
				| SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 RequestDispatcher rs = req.getRequestDispatcher("ecomerce.html");
         rs.forward(req, resp);
	}
	
	

}
