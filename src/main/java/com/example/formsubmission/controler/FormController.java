package com.example.formsubmission.controler;

import com.example.formsubmission.exception.FormSubmitException;
import com.example.formsubmission.model.Form;
import com.example.formsubmission.response.FormResponse;
import com.example.formsubmission.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/submission/v1")
@AllArgsConstructor
public class FormController {

    private final FormService formService;


    @PostMapping("/clientform/submit")
    public ResponseEntity<FormResponse> submitForm(@RequestParam String  formData, @RequestParam(value = "file",required = false) MultipartFile file){
        if(formService.formSubmit(formData, file)){
            return ResponseEntity.ok().body(new FormResponse(HttpStatus.OK.value(),"Form submit success"));
        }
        throw new FormSubmitException();
    }

    @GetMapping("/clientForm/getAllFiles")
    public List<Form> getAllSubmitForms(){
        return formService.getAllSubmitForms();
    }

}
