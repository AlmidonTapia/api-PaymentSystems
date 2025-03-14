package com.atapia.api_PaymentSystems.Service.Estudent.RequestObject;

import java.time.LocalDate;

import com.atapia.api_PaymentSystems.Enums.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdate {
    private String idEstudent;
    private String firstName;
    private String surName;
    private String dni;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private LocalDate birthDate;
}
