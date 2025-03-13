package com.atapia.api_PaymentSystems.Dto;

import java.time.LocalDateTime;

import com.atapia.api_PaymentSystems.Enums.EnrollmentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEnrollmentDto {
    private String idEnrollment;
    private String codEnrollment;
    private String idPayment;
    private String idCourse;
    private EnrollmentStatus status;
    private LocalDateTime enrollmentDate;
}
