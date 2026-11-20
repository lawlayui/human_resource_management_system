package com.lawlayui.hrms.validation;

import java.math.BigDecimal;

import com.lawlayui.hrms.persistence.entity.SalaryComponentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class SalaryComponentRequest {
    @NotBlank
    private String name;
    private SalaryComponentType type;
    @NotNull 
    private boolean isPercentage;
    @NotNull 
    private BigDecimal value;
}
