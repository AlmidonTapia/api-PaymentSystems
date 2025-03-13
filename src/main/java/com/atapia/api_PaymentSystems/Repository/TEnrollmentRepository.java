package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TEnrollment;

@Repository
public interface TEnrollmentRepository extends JpaRepository<TEnrollment, String> {
    
    Optional<TEnrollment> findByIdEnrollment(String idEnrollment);

    Optional<TEnrollment> findByCodEnrollment(String codEnrollment);

    Optional<TEnrollment> findByCodCourse(String codCourse);

    Optional<TEnrollment> findByCodEst(String codEst);

    Optional<TEnrollment> findByCodTeacher(String codTeacher);

    Optional<TEnrollment> findByEnrollmentDate(String enrollmentDate);
}
