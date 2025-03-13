package com.atapia.api_PaymentSystems.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TPayment;

@Repository
public interface TPaymentRepository extends JpaRepository<TPayment, String> {

    Optional<TPayment> findByIdPayment(String idPayment);

    Optional<TPayment> findByCodPayment(String codPayment);

    Optional<TPayment> findByCodEst(String codEst);

    List<TPayment> findByCodCourse(String codCourse);

    Optional<TPayment> findByCodTeacher(String codTeacher);

    Optional<TPayment> findByPaymentDate(String paymentDate);

}
