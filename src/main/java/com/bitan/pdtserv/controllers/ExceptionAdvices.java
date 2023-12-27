package com.bitan.pdtserv.controllers;

import com.bitan.pdtserv.Exception.NotFoundException;
import com.bitan.pdtserv.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotfoundException()
    {

        ErrorResponseDto errorResponseDto= new ErrorResponseDto();
        errorResponseDto.setErrorMessage("Not Found");
        ResponseEntity<ErrorResponseDto> response= new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
        return  response;

    }
}
