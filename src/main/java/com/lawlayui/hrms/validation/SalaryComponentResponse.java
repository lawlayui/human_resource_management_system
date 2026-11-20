package com.lawlayui.hrms.validation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lawlayui.hrms.persistence.entity.SalaryComponentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class SalaryComponentResponse {
    private Integer id;
    private String name;
    private SalaryComponentType type;
    private boolean isPercentage;
    private BigDecimal value;
    private LocalDateTime createdAt;
}
