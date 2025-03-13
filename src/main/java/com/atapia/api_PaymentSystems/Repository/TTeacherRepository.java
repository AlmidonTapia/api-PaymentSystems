package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TTeacher;

@Repository
public interface TTeacherRepository extends JpaRepository<TTeacher, UUID> {

    Optional<TTeacher> findByIdTeacher(UUID idTeacher);

    Optional<TTeacher> findByCodTeach(String codTeach);

    Optional<TTeacher> findByDni(String dni);

    Optional<TTeacher> findByEmail(String email);

    Optional<TTeacher> findByPhoneNumber(String phoneNumber);


}
