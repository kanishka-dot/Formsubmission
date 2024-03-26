package com.example.formsubmission.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
    private Integer age;
    @Column(nullable = false)
    private String address;
    private String message;
    @Column(columnDefinition="MEDIUMBLOB")
    @Lob
    private byte[]  attachment;
    private String filename;
    @Column(nullable = false)
    private String email;
    private Date creDate;
}
