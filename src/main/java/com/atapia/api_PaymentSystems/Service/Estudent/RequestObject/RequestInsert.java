package com.atapia.api_PaymentSystems.Service.Estudent.RequestObject;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestInsert {
    private String firstName;
    private String surName;
    private String dni;
    private String email;
    private String phoneNumber;
    private boolean gender;
    private LocalDate birthDate;

}
