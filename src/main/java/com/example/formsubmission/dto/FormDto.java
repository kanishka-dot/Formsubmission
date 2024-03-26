package com.example.formsubmission.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private Integer ageField;
    private String addressField;
    private String messageField;
    private String emailField;
}
