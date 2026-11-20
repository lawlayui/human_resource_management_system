package com.lawlayui.hrms.validation;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class EmployeeSalaryRequest {
    private Integer employeeId;
    @NotNull 
    private Integer salaryComponentid;
    @NotNull 
    private BigDecimal amount;
}
