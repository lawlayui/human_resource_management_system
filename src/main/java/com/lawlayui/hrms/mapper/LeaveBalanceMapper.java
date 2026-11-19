package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.LeaveBalance;
import com.lawlayui.hrms.validation.LeaveBalanceRequest;
import com.lawlayui.hrms.validation.LeaveBalanceResponse;

public class LeaveBalanceMapper {
    public static LeaveBalanceResponse entityToResponse(LeaveBalance entity) {
        return LeaveBalanceResponse.builder()
        .id(entity.getId())
        .employeeId(entity.getEmployee().getId())
        .year(entity.getYear())
        .totalQuota(entity.getTotalQuota())
        .usedQuota(entity.getUsedQuota())
        .build();
    }

    public static LeaveBalance requestToEntity(LeaveBalanceRequest request) {
        return LeaveBalance.builder()
        .totalQuota(request.getTotalQuota())
        .usedQuota(request.getUsedQuota())
        .year(request.getYear())
        .build();
    }
}
