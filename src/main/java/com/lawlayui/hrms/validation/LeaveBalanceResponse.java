package com.lawlayui.hrms.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class LeaveBalanceResponse {
    private Integer id;
    private Integer employeeId;
    private Integer year;
    private Integer totalQuota;
    private Integer usedQuota;
}
