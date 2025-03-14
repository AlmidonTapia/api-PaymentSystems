package com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject;

import com.atapia.api_PaymentSystems.Dto.TEstudentDto;
import com.atapia.api_PaymentSystems.Service.Generic.ResponseGeneric;

public class ResponseUpdate extends ResponseGeneric {
    public class Response {
        public TEstudentDto estudent;
    }

    public Response dto = new Response();

}
