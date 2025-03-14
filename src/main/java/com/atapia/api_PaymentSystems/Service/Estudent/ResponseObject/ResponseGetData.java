package com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject;



import com.atapia.api_PaymentSystems.Dto.TEstudentDto;
import com.atapia.api_PaymentSystems.Service.Generic.ResponseGeneric;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGetData extends ResponseGeneric{

    public class Response {
        public TEstudentDto estudent;
    }

    public Response dto = new Response();

}
