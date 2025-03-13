package com.atapia.api_PaymentSystems.Dto;

import java.time.LocalDateTime;

import com.atapia.api_PaymentSystems.Enums.PaymentStatus;
import com.atapia.api_PaymentSystems.Enums.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPaymentDto {
    private String idPayment;
    private String codPayment;
    private LocalDateTime paymentDate;
    private Double amount;
    private PaymentType type;
    private PaymentStatus status;
    private String file;
    private String idEstudent;
}
