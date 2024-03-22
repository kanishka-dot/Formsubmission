package com.example.formsubmission.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "form")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formId;
    @Column(nullable = false)
    private Integer ageField;
    @Column(nullable = false)
    private String addressField;
    private String messageField;
    @Column(columnDefinition="MEDIUMBLOB")
    @Lob
    private byte[]  attachmentField;
    @Column(nullable = false)
    private String emailField;
    private Date creDate;
}
