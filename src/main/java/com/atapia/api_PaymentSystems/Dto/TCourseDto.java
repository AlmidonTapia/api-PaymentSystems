package com.atapia.api_PaymentSystems.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCourseDto {
    private String idCourse;
    private String codCourse;
    private String name;
    private String description;
    private int credits;
    private double price;
    private String idTeacher;
    private int maxStudents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
