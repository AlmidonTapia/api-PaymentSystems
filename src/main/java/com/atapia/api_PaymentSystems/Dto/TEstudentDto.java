package com.atapia.api_PaymentSystems.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEstudentDto {
    private UUID idEstudent;
    private String firstName;
    private String surName;
    private String dni;
    private String email;
    private String phoneNumber;
    private String codEst;
    private boolean gender;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
