package com.lawlayui.hrms.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Getter 
@Setter 
public class EmployeeResponse {
    private Integer id;
    private String fullName;
    private Integer departmentId; 
}
