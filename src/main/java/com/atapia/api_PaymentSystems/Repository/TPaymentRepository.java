package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TPayment;

@Repository
public interface TPaymentRepository extends JpaRepository<TPayment, UUID> {

    Optional<TPayment> findByIdPayment(UUID idPayment);

    Optional<TPayment> findByCodPayment(String codPayment);

    //Optional<TPayment> findByIdEstudent(String idEstudent);

   // List<TPayment> findByCodCourse(String codCourse);

    //Optional<TPayment> findByCodTeacher(String codTeacher);

    //Optional<TPayment> findByPaymentDate(String paymentDate);

}
