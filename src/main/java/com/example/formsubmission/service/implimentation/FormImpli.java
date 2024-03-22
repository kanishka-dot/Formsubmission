package com.example.formsubmission.service.implimentation;

import com.example.formsubmission.dto.FormDto;
import com.example.formsubmission.response.FormResponse;
import com.example.formsubmission.service.FormService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FormImpli implements FormService {

    @Override
    public FormResponse formSubmit(FormDto formDto, MultipartFile file) {
        return null;
    }
}
