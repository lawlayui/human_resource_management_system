package com.lawlayui.hrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lawlayui.hrms.service.exception.AttendanceNotFoundException;
import com.lawlayui.hrms.service.exception.DepartmentNotFoundException;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.service.exception.LeaveBalanceNotFoundException;
import com.lawlayui.hrms.validation.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse("INVALID ARGUMENT", errorMessage);
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().iterator().next().getMessage();

        ErrorResponse errorResponse = new ErrorResponse("INVALID ARGUMENT", errorMessage);
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AttendanceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAtendanceNotFound(AttendanceNotFoundException ex) {
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("NOT FOUND", errorMessage);
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotFound(DepartmentNotFoundException ex) {
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("NOT FOUND", errorMessage);
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotfound(EmployeeNotFoundException ex) {
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("NOT FOUND", errorMessage);
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @ExceptionHandler(LeaveBalanceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLeaveBalanceNotFound(LeaveBalanceNotFoundException ex) {
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("NOT FOUND", errorMessage);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalException(Exception ex) {
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL SERVER", errorMessage);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}