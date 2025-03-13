package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TEstudent;

@Repository
public interface TEstudentRepository extends JpaRepository<TEstudent, String> {

    Optional<TEstudent> findByIdEstudent(String idEstudent);

    Optional<TEstudent> findByDni(String dni);

    Optional<TEstudent> findByCodEst(String codEst);


    

}
