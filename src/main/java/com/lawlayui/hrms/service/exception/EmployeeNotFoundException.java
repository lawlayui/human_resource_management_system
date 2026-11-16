package com.lawlayui.hrms.service.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
