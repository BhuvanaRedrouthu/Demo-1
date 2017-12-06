package com.simplify.service;

import com.simplify.payments.PaymentsApi;

public class BaseService {

	public BaseService() {
		PaymentsApi.PUBLIC_KEY = "sbpb_ZDE5NzNiMDUtMmFmZS00ZDY2LTgwMjktYjJmMThiNmNlNmU3";
		PaymentsApi.PRIVATE_KEY = "0A27YuEcCUdmK5vmLK94RK7B0aszqpO9V3mK/q0D74p5YFFQL0ODSXAOkNtXTToq";
	}
}
