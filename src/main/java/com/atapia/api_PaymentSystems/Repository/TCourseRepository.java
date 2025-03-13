package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TCourse;

@Repository
public interface TCourseRepository extends JpaRepository<TCourse, String> {

    Optional<TCourse> findByIdCourse(String idCourse);

    Optional<TCourse> findByCodCourse(String codCourse);

    Optional<TCourse> findByName(String name);

    
    
}
