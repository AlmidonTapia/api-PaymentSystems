package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.atapia.api_PaymentSystems.Enums.PaymentStatus;
import com.atapia.api_PaymentSystems.Enums.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tpayment")
@Getter
@Setter
public class TPayment implements Serializable {

    @Id
    @Column(name = "idPayment")
    private UUID idPayment;

    @Column(name = "codPayment", unique = true)
    private String codPayment;

    @Column(name = "paymentDate")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status;

    @Column(name = "file")
    private String file;

    @ManyToOne
    @JoinColumn(name = "idEstudent")
    private TEstudent estudent;

    @OneToMany(mappedBy = "payment")
    private List<TEnrollment> enrollments;

}
