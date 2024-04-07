package com.example.formsubmission.service.implimentation;

import com.example.formsubmission.dto.FormDto;
import com.example.formsubmission.exception.FormSubmitException;
import com.example.formsubmission.exception.InvalidFileFormatException;
import com.example.formsubmission.model.Form;
import com.example.formsubmission.repo.FormRepo;
import com.example.formsubmission.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FormImpl implements FormService {

    private final FormRepo formRepo;
    private final ObjectMapper objectMapper;

    @Override
    public boolean formSubmit(String formObject, MultipartFile file) {
        try{
            FormDto formDto =objectMapper.readValue(formObject, FormDto.class);
            String fileName = "";
            byte[] fileBytes = null;

         if(file != null){
             String extension = FilenameUtils.getExtension(Objects.requireNonNull(file.getOriginalFilename()));
             if(!validateFileType(extension)){
                 throw new InvalidFileFormatException();
             }
             fileName = file.getOriginalFilename();
             fileBytes = file.getBytes();
         }
         Form form = Form.builder().age(formDto.getAgeField())
                    .email(formDto.getEmailField())
                    .message(formDto.getMessageField())
                    .address(formDto.getAddressField())
                    .creDate(Date.valueOf(LocalDate.now()))
                    .filename(fileName)
                    .attachment(fileBytes).build();
         formRepo.save(form);
        }catch (FormSubmitException | IOException ex){
            ex.printStackTrace();
            return false;
        }
            return true;
    }
    @Override
    public List<Form> getAllSubmitForms() {
       return formRepo.findAll();
    }

    private boolean validateFileType(String prmFileExt){
        return prmFileExt.equalsIgnoreCase("png")
                || prmFileExt.equalsIgnoreCase("jpg")
                || prmFileExt.equalsIgnoreCase("jpeg");
    }
}
