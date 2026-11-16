package com.lawlayui.hrms.service.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String msg) {
        super(msg);
    }
}
