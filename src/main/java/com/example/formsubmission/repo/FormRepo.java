package com.example.formsubmission.repo;

import com.example.formsubmission.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepo extends JpaRepository<Form, Integer> {
}
