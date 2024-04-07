package com.example.formsubmission.service;


import com.example.formsubmission.model.Form;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FormService {

    boolean formSubmit(String formDto, MultipartFile file);

    List<Form> getAllSubmitForms();

}
