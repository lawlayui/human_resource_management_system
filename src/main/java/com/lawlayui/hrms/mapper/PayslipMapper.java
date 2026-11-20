package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.Payslip;
import com.lawlayui.hrms.validation.PayslipResponse;

public class PayslipMapper {
    public static PayslipResponse entityToResponse(Payslip entity) {
        return PayslipResponse.builder()
        .id(entity.getId())
        .payrollRunId(entity.getPayrollRun().getId())
        .employeeId(entity.getEmployee().getId())
        .grossSalary(entity.getGrossSalary())
        .totalDeduction(entity.getTotalDeductions())
        .takeHomePay(entity.getTakeHomePay())
        .detailsJson(entity.getDetailsJson())
        .createdAt(entity.getCreatedAt())
        .build();
    }
}
