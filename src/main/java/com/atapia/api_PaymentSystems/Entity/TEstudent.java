package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "testudent")
@Getter
@Setter
public class TEstudent implements Serializable {

    @Id
    @Column(name = "idEstudent")
    private String idEstudent;

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

    @Column(name = "codEst", unique = true)
    private String codEst;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
