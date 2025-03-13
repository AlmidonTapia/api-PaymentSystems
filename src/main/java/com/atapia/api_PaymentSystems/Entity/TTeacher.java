package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tteacher")
@Getter
@Setter
public class TTeacher implements Serializable {

    @Id
    @Column(name = "idTeacher")
    private String idTeacher;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "codTeach", unique = true)
    private String codTeach;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
