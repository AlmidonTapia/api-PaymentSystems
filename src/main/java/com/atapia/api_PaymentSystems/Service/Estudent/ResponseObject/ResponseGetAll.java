package com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject;

import java.util.ArrayList;
import java.util.List;

import com.atapia.api_PaymentSystems.Service.Generic.ResponseGeneric;

public class ResponseGetAll extends ResponseGeneric {
    public class Response {
		public List<Object> listEstudent = new ArrayList<>();
	}

	public Response dto = new Response();
}
