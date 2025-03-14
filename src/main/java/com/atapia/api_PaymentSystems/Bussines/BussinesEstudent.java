package com.atapia.api_PaymentSystems.Bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atapia.api_PaymentSystems.Dto.TEstudentDto;
import com.atapia.api_PaymentSystems.Entity.TEstudent;
import com.atapia.api_PaymentSystems.Repository.TEstudentRepository;

import jakarta.transaction.Transactional;

@Service
public class BussinesEstudent {

    @Autowired
    private TEstudentRepository repoEstudent;

    public void saveEstudent(TEstudentDto dtoEstudent) throws Exception {
        Optional<TEstudent> existingEstudent = repoEstudent.findByDni(dtoEstudent.getDni());
        if (existingEstudent.isPresent()) {
            throw new Exception("Ya existe un estudiante con el DNI: " + dtoEstudent.getDni());
        }

        dtoEstudent.setIdEstudent(UUID.randomUUID());
        dtoEstudent.setCreatedAt(LocalDateTime.now());
        dtoEstudent.setUpdatedAt(LocalDateTime.now());

        TEstudent testudent = new TEstudent();

        testudent.setIdEstudent(dtoEstudent.getIdEstudent());
        testudent.setFirstName(dtoEstudent.getFirstName());
        testudent.setSurName(dtoEstudent.getSurName());
        testudent.setDni(dtoEstudent.getDni());
        testudent.setEmail(dtoEstudent.getEmail());
        testudent.setPhoneNumber(dtoEstudent.getPhoneNumber());

        try {
            String studentCode = generateStudentCode(dtoEstudent.getFirstName(), dtoEstudent.getDni(),
                    dtoEstudent.getSurName());
            testudent.setCodEst(studentCode);

            testudent.setGender(dtoEstudent.getGender());
            testudent.setBirthDate(dtoEstudent.getBirthDate());
            testudent.setCreatedAt(dtoEstudent.getCreatedAt());
            testudent.setUpdatedAt(dtoEstudent.getUpdatedAt());

            repoEstudent.save(testudent);
        } catch (Exception e) {
            throw new Exception("Error al guardar el estudiante: " + e.getMessage(), e);
        }
    }

    public List<TEstudentDto> getAllEstudents() throws Exception {
        List<TEstudent> listEstudents = repoEstudent.findAll();
        List<TEstudentDto> listDtoEstudents = new ArrayList<>();

        for (TEstudent tEstudent : listEstudents) {
            TEstudentDto dtoEstudent = new TEstudentDto();
            dtoEstudent.setIdEstudent(tEstudent.getIdEstudent());
            dtoEstudent.setFirstName(tEstudent.getFirstName());
            dtoEstudent.setSurName(tEstudent.getSurName());
            dtoEstudent.setDni(tEstudent.getDni());
            dtoEstudent.setEmail(tEstudent.getEmail());
            dtoEstudent.setPhoneNumber(tEstudent.getPhoneNumber());
            dtoEstudent.setCodEst(tEstudent.getCodEst());
            dtoEstudent.setGender(tEstudent.getGender());
            dtoEstudent.setBirthDate(tEstudent.getBirthDate());
            dtoEstudent.setCreatedAt(tEstudent.getCreatedAt());
            dtoEstudent.setUpdatedAt(tEstudent.getUpdatedAt());

            listDtoEstudents.add(dtoEstudent);
        }

        return listDtoEstudents;
    }

    @Transactional
    public boolean delete(UUID idEstudent) throws Exception {
        Optional<TEstudent> tEstudent = repoEstudent.findByIdEstudent(idEstudent);

        if (tEstudent.isPresent()) {
            repoEstudent.deleteById(idEstudent);
            return true;
        } else {
            throw new Exception("No se encontró el estudiante con el ID: " + idEstudent);
        }
    }

    @Transactional
    public void updateEstudent(TEstudentDto dtoEstudent) throws Exception {
        Optional<TEstudent> tEstudent = repoEstudent.findByIdEstudent(dtoEstudent.getIdEstudent());

        if (tEstudent.isPresent()) {
            TEstudent testudent = tEstudent.get();

            testudent.setFirstName(dtoEstudent.getFirstName());
            testudent.setSurName(dtoEstudent.getSurName());
            testudent.setDni(dtoEstudent.getDni());
            testudent.setEmail(dtoEstudent.getEmail());
            testudent.setPhoneNumber(dtoEstudent.getPhoneNumber());
            testudent.setGender(dtoEstudent.getGender());
            testudent.setBirthDate(dtoEstudent.getBirthDate());
            testudent.setUpdatedAt(LocalDateTime.now());

            repoEstudent.save(testudent);
        } else {
            throw new Exception("No se encontró el estudiante con el ID: " + dtoEstudent.getIdEstudent());
        }
    }

    private String generateStudentCode(String firstName, String dni, String surName) throws IllegalArgumentException {
        if (firstName == null || dni == null || surName == null) {
            throw new IllegalArgumentException("Los campos nombre, dni y apeliidos no pueden ser nulos");
        }

        String firstNamePart = firstName.length() >= 2 ? firstName.substring(0, 2) : firstName;
        String dniPart = dni.length() >= 3 ? dni.substring(0, 3) : dni;
        String surNamePart = surName.length() >= 3 ? surName.substring(0, 3) : surName;
        String studentCode = (firstNamePart + dniPart + surNamePart).toUpperCase();
        return studentCode.length() > 8 ? studentCode.substring(0, 8) : studentCode;
    }

    public TEstudentDto getEstudentByCodEst(String codEst) throws Exception {
        Optional<TEstudent> tEstudent = repoEstudent.findByCodEst(codEst);

        TEstudentDto dtoEstudent = null;

        if (tEstudent.isPresent()) {
            dtoEstudent = new TEstudentDto();
            dtoEstudent.setIdEstudent(tEstudent.get().getIdEstudent());
            dtoEstudent.setFirstName(tEstudent.get().getFirstName());
            dtoEstudent.setSurName(tEstudent.get().getSurName());
            dtoEstudent.setDni(tEstudent.get().getDni());
            dtoEstudent.setEmail(tEstudent.get().getEmail());
            dtoEstudent.setPhoneNumber(tEstudent.get().getPhoneNumber());
            dtoEstudent.setCodEst(tEstudent.get().getCodEst());
            dtoEstudent.setGender(tEstudent.get().getGender());
            dtoEstudent.setBirthDate(tEstudent.get().getBirthDate());
            dtoEstudent.setCreatedAt(tEstudent.get().getCreatedAt());
            dtoEstudent.setUpdatedAt(tEstudent.get().getUpdatedAt());
        }

        return dtoEstudent;
    }

    public TEstudentDto getEstudentByDniOrCodEst(String dniOrCodEst) throws Exception {
        Optional<TEstudent> tEstudent = repoEstudent.findByDni(dniOrCodEst);
        if (!tEstudent.isPresent()) {
            tEstudent = repoEstudent.findByCodEst(dniOrCodEst);
        }

        TEstudentDto dtoEstudent = null;

        if (tEstudent.isPresent()) {
            dtoEstudent = new TEstudentDto();
            dtoEstudent.setIdEstudent(tEstudent.get().getIdEstudent());
            dtoEstudent.setFirstName(tEstudent.get().getFirstName());
            dtoEstudent.setSurName(tEstudent.get().getSurName());
            dtoEstudent.setDni(tEstudent.get().getDni());
            dtoEstudent.setEmail(tEstudent.get().getEmail());
            dtoEstudent.setPhoneNumber(tEstudent.get().getPhoneNumber());
            dtoEstudent.setCodEst(tEstudent.get().getCodEst());
            dtoEstudent.setGender(tEstudent.get().getGender());
            dtoEstudent.setBirthDate(tEstudent.get().getBirthDate());
            dtoEstudent.setCreatedAt(tEstudent.get().getCreatedAt());
            dtoEstudent.setUpdatedAt(tEstudent.get().getUpdatedAt());
        }

        return dtoEstudent;
    }

    public boolean existsByDni(String dni) {
        return repoEstudent.findByDni(dni).isPresent();
    }
}
