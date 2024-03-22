package com.example.formsubmission.controler;

import com.example.formsubmission.dto.FormDto;
import com.example.formsubmission.response.FormResponse;
import com.example.formsubmission.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RestController("/submission/v1")
@AllArgsConstructor
public class FormController {

    private final FormService formService;

    @PostMapping("/clientform/submit")
    public ResponseEntity<FormResponse> submitForm(@RequestBody FormDto formDto, @RequestParam("file") MultipartFile file){
       FormResponse formResponse =  formService.formSubmit(formDto, file);
    return ResponseEntity.ok().body(formResponse);
    }

}
