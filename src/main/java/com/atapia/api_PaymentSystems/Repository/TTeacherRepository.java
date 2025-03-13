package com.atapia.api_PaymentSystems.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atapia.api_PaymentSystems.Entity.TTeacher;

@Repository
public interface TTeacherRepository extends JpaRepository<TTeacher, String> {

    Optional<TTeacher> findByIdTeacher(String idTeacher);

    Optional<TTeacher> findByCodTeacher(String codTeacher);

    Optional<TTeacher> findByDni(String dni);

    Optional<TTeacher> findByEmail(String email);

    Optional<TTeacher> findByPhone(String phone);


}
