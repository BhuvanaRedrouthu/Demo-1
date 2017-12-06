package com.simplify.service;

import com.simplify.model.CustomerData;
import com.simplify.payments.PaymentsMap;

import com.simplify.payments.domain.Customer;
import com.simplify.payments.domain.Payment;
import com.simplify.payments.exception.ApiCommunicationException;
import com.simplify.payments.exception.AuthenticationException;
import com.simplify.payments.exception.InvalidRequestException;
import com.simplify.payments.exception.NotAllowedException;
import com.simplify.payments.exception.ObjectNotFoundException;
import com.simplify.payments.exception.SystemException;

public class CustomerService extends BaseService {

	public String registerCustomer(String email, String name, long cardNumber,
			int expMonth, int expYear, int cvc) throws ApiCommunicationException, AuthenticationException,
			InvalidRequestException, NotAllowedException, SystemException {
		Customer customer = Customer.create(new PaymentsMap()
		           .set("email", email)
		           .set("name", name)
		           .set("card.cvc", cvc)
		           .set("card.expMonth", expMonth)
		           .set("card.expYear", expYear)
		           .set("card.number", cardNumber));
		CustomerData.addCustomerId((String) customer.get("id"));
		return (String) customer.get("id");
	}
	
	public String generateToken(String customerId) throws ApiCommunicationException, AuthenticationException, InvalidRequestException, ObjectNotFoundException, NotAllowedException, SystemException {
		Customer customer = Customer.find(customerId);
		return (String) customer.get("token");
	}
	
	public static void main(String[] args) throws ApiCommunicationException, AuthenticationException, InvalidRequestException, ObjectNotFoundException, NotAllowedException, SystemException {
		CustomerService customerService = new CustomerService();
		
		/*CardToken cardToken = CardToken.create(new PaymentsMap()        
        .set("card.cvc", "123")
        .set("card.expMonth", 11)
        .set("card.expYear", 19)
        .set("card.number", "5555555555554444")
       );
		System.out.println(cardToken.get("card.id"));
		//CardToken token = CardToken.find("G6bejgjMG");
*/		Customer customer = Customer.find("G6bejgjMG");
		customer.set("subscriptions.amount", 1000);		
		//customer.update();
		Payment payment = Payment.create(new PaymentsMap()
        .set("amount", 5000)
		.set("currency", "USD")
		.set("description", "desc")
		.set("customer","G6bejgjMG")
		/*//.set("reference", "7a6ef6be31")
		.set("token", cardToken.get("id"))*/);

if ("APPROVED".equals(payment.get("paymentStatus"))) {
	System.out.println("Approved");
}
	}
}
