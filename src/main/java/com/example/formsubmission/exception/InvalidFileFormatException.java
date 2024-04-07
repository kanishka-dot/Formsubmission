package com.example.formsubmission.exception;

public class InvalidFileFormatException extends RuntimeException{
    public InvalidFileFormatException(){
        super("Invalid File Format. Accept only jpg and png");
    }
}
