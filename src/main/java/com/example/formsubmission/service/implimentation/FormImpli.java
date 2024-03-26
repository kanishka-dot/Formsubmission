package com.example.formsubmission.service.implimentation;

import com.example.formsubmission.dto.FormDto;
import com.example.formsubmission.exception.FormSubmitException;
import com.example.formsubmission.model.Form;
import com.example.formsubmission.repo.FormRepo;
import com.example.formsubmission.response.FormResponse;
import com.example.formsubmission.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FormImpli implements FormService {

    private final FormRepo formRepo;
    private final ObjectMapper objectMapper;

    @Override
    public boolean formSubmit(String formObject, MultipartFile file) {
        try{
         FormDto formDto =objectMapper.readValue(formObject, FormDto.class);
         Form form = Form.builder().age(formDto.getAgeField())
                    .email(formDto.getEmailField())
                    .message(formDto.getMessageField())
                    .address(formDto.getAddressField())
                    .creDate(Date.valueOf(LocalDate.now()))
                    .filename(file.getOriginalFilename())
                    .attachment(file.getBytes()).build();
         formRepo.save(form);
        }catch (Exception ex){
            ex.printStackTrace();
        return false;
        }
        return true;
    }
}
