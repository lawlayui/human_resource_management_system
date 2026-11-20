package com.lawlayui.hrms.validation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class PayslipResponse {
    private Integer id;
    private Integer payrollRunId;
    private Integer employeeId;
    private BigDecimal grossSalary;
    private BigDecimal totalDeduction;
    private BigDecimal takeHomePay;
    private String detailsJson;
    private LocalDateTime createdAt;
}
