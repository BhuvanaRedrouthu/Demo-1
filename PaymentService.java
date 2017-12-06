package com.simplify.service;

import com.simplify.payments.PaymentsApi;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import com.simplify.payments.exception.ApiCommunicationException;
import com.simplify.payments.exception.AuthenticationException;
import com.simplify.payments.exception.InvalidRequestException;
import com.simplify.payments.exception.NotAllowedException;
import com.simplify.payments.exception.SystemException;

public class PaymentService extends BaseService{

	public String payAmount(int amount, String description, String customerId) throws ApiCommunicationException,
			AuthenticationException, InvalidRequestException,
			NotAllowedException, SystemException {
		Payment payment = Payment.create(new PaymentsMap()
		        .set("amount", amount)
				.set("currency", "USD")
				.set("description", description)
				//.set("reference", "7a6ef6be31")
				.set("customer", customerId));

		if ("APPROVED".equals(payment.get("paymentStatus"))) {
			return "Payment approved";
		} else if ("APPROVED".equals(payment.get("paymentStatus"))) {
			return "Payment approved";
		} else {
			return "Payment Pending";
		}
	}
}
