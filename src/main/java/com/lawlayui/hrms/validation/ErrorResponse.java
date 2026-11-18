package com.lawlayui.hrms.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
}
