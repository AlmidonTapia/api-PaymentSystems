package com.atapia.api_PaymentSystems.Service.Estudent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atapia.api_PaymentSystems.Bussines.BussinesEstudent;
import com.atapia.api_PaymentSystems.Dto.TEstudentDto;
import com.atapia.api_PaymentSystems.Service.Estudent.RequestObject.RequestInsert;
import com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject.ResponseDelete;
import com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject.ResponseGetAll;
import com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject.ResponseGetData;
import com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject.ResponseInsert;
import com.atapia.api_PaymentSystems.Service.Estudent.ResponseObject.ResponseUpdate;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("Estudent")
public class EstudentController {

    @Autowired
    private BussinesEstudent bussinesEstudent;

    @GetMapping(path = "getdata")
	public ResponseEntity<ResponseGetData> getData() {
		ResponseGetData responseGetData = new ResponseGetData();

		try {
			responseGetData.firstName = "Saul";
			responseGetData.surName = "Tapia Almidon";
			responseGetData.dni = "12345678";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(responseGetData, HttpStatus.OK);
	}

    @GetMapping("/getall")
	public ResponseEntity<ResponseGetAll> getAll() {
		ResponseGetAll response = new ResponseGetAll();

		try {
			List<TEstudentDto> listDtoEstudent= bussinesEstudent.getAllEstudents();

			for (TEstudentDto item : listDtoEstudent) {
				Map<String, Object> map = new HashMap<>();

				map.put("idEstudent", item.getIdEstudent());
                map.put("firstName", item.getFirstName());
                map.put("surName", item.getSurName());
                map.put("dni", item.getDni());
                map.put("email", item.getEmail());
                map.put("phoneNumber", item.getPhoneNumber());
                map.put("codEst", item.getCodEst());
                map.put("gender", item.isGender());
                map.put("birthDate", item.getBirthDate());
                map.put("createdAt", item.getCreatedAt());
                map.put("updatedAt", item.getUpdatedAt());

				response.dto.listEstudent.add(map);

				response.mo.setSuccess();
			}
		} catch (Exception e) {
			response.mo.addMessage("Ocurrió un error inesperado, estamos trabajando para resolvero. Gracias por su paciencia.");
			response.mo.setException();
		}

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "insert", consumes = "multipart/form-data")
    public ResponseEntity<ResponseInsert> insert(@Valid @ModelAttribute RequestInsert request, BindingResult bindingResult) {
        ResponseInsert response = new ResponseInsert();
        
        try {
            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(error -> {
                    response.mo.addMessage(error.getDefaultMessage());
                });

                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            // Verifica si existe un estudiante con el DNI proporcionado
            if (bussinesEstudent.existsByDni(request.getDni())) {
                response.mo.addMessage("El estudiante con el DNI proporcionado ya existe.");
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }

            TEstudentDto dtoEstudent = new TEstudentDto();

            dtoEstudent.setFirstName(request.getFirstName());
            dtoEstudent.setSurName(request.getSurName());
            dtoEstudent.setDni(request.getDni());
            dtoEstudent.setEmail(request.getEmail());
            dtoEstudent.setPhoneNumber(request.getPhoneNumber());
            dtoEstudent.setGender(request.isGender());
            dtoEstudent.setBirthDate(request.getBirthDate());

            bussinesEstudent.saveEstudent(dtoEstudent);
            response.mo.addMessage("Estudiante registrado correctamente.");
            response.mo.setSuccess();
        } catch (Exception e) {
            response.mo.addMessage("Ocurrió un error inesperado, estamos trabajando para resolvero. Gracias por su paciencia.");
            response.mo.setException();
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "delete/{idEstudent}")
    public ResponseEntity<ResponseDelete> delete(@PathVariable UUID idEstudent) {
        ResponseDelete response = new ResponseDelete();

        try {
            bussinesEstudent.delete(idEstudent);
            response.mo.addMessage("Estudiante eliminado correctamente.");
            response.mo.setSuccess();
        } catch (Exception e) {
            response.mo.addMessage("Ocurrió un error inesperado, estamos trabajando para resolvero. Gracias por su paciencia.");
            response.mo.setException();
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "update", consumes = "multipart/form-data")
    public ResponseEntity<ResponseUpdate> update(@Valid @ModelAttribute RequestInsert request, BindingResult bindingResult) {
        ResponseUpdate response = new ResponseUpdate();

        try {
            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(error -> {
                    response.mo.addMessage(error.getDefaultMessage());
                });

                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            TEstudentDto dtoEstudent = new TEstudentDto();

            dtoEstudent.setFirstName(request.getFirstName());
            dtoEstudent.setSurName(request.getSurName());
            dtoEstudent.setDni(request.getDni());
            dtoEstudent.setEmail(request.getEmail());
            dtoEstudent.setPhoneNumber(request.getPhoneNumber());
            dtoEstudent.setGender(request.isGender());
            dtoEstudent.setBirthDate(request.getBirthDate());

            bussinesEstudent.saveEstudent(dtoEstudent);
            
            response.mo.addMessage("Estudiante actualizado correctamente.");
            response.mo.setSuccess();
        } catch (Exception e) {
            response.mo.addMessage("Ocurrió un error inesperado, estamos trabajando para resolvero. Gracias por su paciencia.");
            response.mo.setException();
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
