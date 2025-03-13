package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "testudent")
@Getter
@Setter
public class TEstudent implements Serializable {

    @Id
    @Column(name = "idEstudent")
    private UUID idEstudent;

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

    @OneToMany(mappedBy = "estudent")
    private List<TPayment> payments;

}
