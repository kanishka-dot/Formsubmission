package com.example.formsubmission.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
