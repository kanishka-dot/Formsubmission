package com.example.formsubmission.service;

import com.example.formsubmission.dto.FormDto;
import com.example.formsubmission.response.FormResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface FormService {

    FormResponse formSubmit(FormDto formDto, MultipartFile file);

}
