package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.EmployeeSalary;
import com.lawlayui.hrms.validation.EmployeeSalaryRequest;
import com.lawlayui.hrms.validation.EmployeeSalaryResponse;

public class EmployeeSalaryMapper {
    public static EmployeeSalaryResponse entityToResponse(EmployeeSalary entity) {
        return EmployeeSalaryResponse.builder()
        .id(entity.getId())
        .amount(entity.getAmount())
        .salaryComponentId(entity.getSalaryComponent().getId())
        .build();
    }

    public static EmployeeSalary requestToEntity(EmployeeSalaryRequest request) {
        return EmployeeSalary.builder()
        .amount(request.getAmount())
        .build();
    }
}
