package com.atapia.api_PaymentSystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApiPaymentSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPaymentSystemsApplication.class, args);
	}

}
