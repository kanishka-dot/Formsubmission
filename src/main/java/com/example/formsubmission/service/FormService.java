package com.example.formsubmission.service;


import org.springframework.web.multipart.MultipartFile;



public interface FormService {

    boolean formSubmit(String formDto, MultipartFile file);

}
