package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.atapia.api_PaymentSystems.Enums.EnrollmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tenrollment")
@Getter
@Setter
public class TEnrollment implements Serializable {

    @Id
    @Column(name = "idEnrollment")
    private String idEnrollment;

    @Column(name = "codEnrollment", unique = true)
    private String codEnrollment;

    @ManyToOne
    @JoinColumn(name = "idPayment")
    private TPayment payment;
    

    @Column(name = "status")
    private EnrollmentStatus   status;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private TCourse course;

    @Column(name = "enrollmentDate")
    private LocalDateTime enrollmentDate;

}
