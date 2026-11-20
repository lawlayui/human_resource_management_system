package com.lawlayui.hrms.validation;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class EmployeeSalaryResponse {
    private Integer id;
    private Integer salaryComponentId;
    private BigDecimal amount;
}
