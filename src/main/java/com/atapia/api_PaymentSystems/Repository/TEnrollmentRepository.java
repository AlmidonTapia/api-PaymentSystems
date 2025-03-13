package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TEnrollment;

@Repository
public interface TEnrollmentRepository extends JpaRepository<TEnrollment, UUID> {
    
    Optional<TEnrollment> findByIdEnrollment(UUID idEnrollment);
    Optional<TEnrollment> findByCodEnrollment(String codEnrollment);

    // Get by courseId
    //Optional<TEnrollment> findByIdCourse(UUID idCourse);
    //Optional<TEnrollment> findByIdEnrollment(String idEnrollment);

    //Optional<TEnrollment> findByCodEnrollment(String codEnrollment);

    //Optional<TEnrollment> findByIdCourse(String idCourse);
    //Optional<TEnrollment> findByCodPayment(String codPayment);

   // Optional<TEnrollment> findByCodEst(String codEst);

    //Optional<TEnrollment> findByCodTeacher(String codTeacher);

    //Optional<TEnrollment> findByEnrollmentDate(String enrollmentDate);
}
