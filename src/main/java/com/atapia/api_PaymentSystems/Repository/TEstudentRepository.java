package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TEstudent;

@Repository
public interface TEstudentRepository extends JpaRepository<TEstudent, UUID> {

    Optional<TEstudent> findByIdEstudent(UUID idEstudent);

    Optional<TEstudent> findByDni(String dni);

    Optional<TEstudent> findByCodEst(String codEst);


    

}
