package com.chems.Serietemporelle.tp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public String handleException(Exception e, Model model, HttpServletResponse response){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("exception", apiException);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        e.printStackTrace();
        return "errors/error";
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public String handleHttpClientErrorException(HttpClientErrorException e, Model model, HttpServletResponse response){
        ApiException apiException = new ApiException(e.getMessage(), e.getStatusCode());
        model.addAttribute("exception", apiException);
        response.setStatus(e.getStatusCode().value());
        e.printStackTrace();
        return "errors/error";
    }

    @ExceptionHandler(value = {ResourceAccessException.class})
    public String handleResourceAccessException(ResourceAccessException e, Model model, HttpServletResponse response){
        ApiException apiException = new ApiException("", HttpStatus.SERVICE_UNAVAILABLE);
        model.addAttribute("exception", apiException);
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        e.printStackTrace();
        return "errors/error";
    }

    @ExceptionHandler(value = {HttpServerErrorException.class})
    public String handleHttpServerErrorException(HttpServerErrorException e, Model model, HttpServletResponse response){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        model.addAttribute("exception", apiException);
        response.setStatus(e.getStatusCode().value());
        e.printStackTrace();
        return "errors/error";
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public String handleRuntimeException(RuntimeException e, Model model, HttpServletResponse response){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST);
        model.addAttribute("exception", apiException);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        e.printStackTrace();
        return "errors/error";
    }


}
