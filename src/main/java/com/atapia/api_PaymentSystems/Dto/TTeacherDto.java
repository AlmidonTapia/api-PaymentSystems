package com.atapia.api_PaymentSystems.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TTeacherDto {
    private String idTeacher;
    private String firstName;
    private String surName;
    private String dni;
    private String email;
    private String phoneNumber;
    private String codTeach;
    private boolean gender;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
