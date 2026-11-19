package com.lawlayui.hrms.validation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Setter 
@Getter 
public class LeaveBalanceRequest {
    @NotNull 
    private Integer employeeId;
    @NotNull 
    private Integer year;
    @NotNull 
    private Integer totalQuota;
    @NotNull 
    private Integer usedQuota;
}
