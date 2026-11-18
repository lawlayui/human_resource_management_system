package com.lawlayui.hrms.mapper;

import java.time.LocalDateTime;

import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.validation.EmployeeRequest;
import com.lawlayui.hrms.validation.EmployeeResponse;
import com.lawlayui.hrms.validation.EmployeeResponseDetail;

public class EmployeeMapper {
    public static Employee requestToEntity(EmployeeRequest request) {
        return Employee.builder()
        .nik(request.getNik())
        .fullName(request.getFullName())
        .email(request.getEmail())
        .phone(request.getPhone())
        .hireDate(request.getHireDate())
        .employmentStatus(request.getEmploymentStatus())
        .position(request.getPosition())
        .createdAt(LocalDateTime.now())
        .build();
    }

    public static EmployeeResponseDetail entityToResponseDetail(Employee entity) {
        return EmployeeResponseDetail.builder()
        .id(entity.getId())
        .nik(entity.getNik())
        .fullName(entity.getFullName())
        .email(entity.getEmail())
        .phone(entity.getPhone())
        .hireDate(entity.getHireDate())
        .employmentStatus(entity.getEmploymentStatus())
        .position(entity.getPosition())
        .departmentId(entity.getDepartment().getId())
        .build();
    }

    public static EmployeeResponse entityToResponse(Employee entity) {
        return EmployeeResponse.builder()
        .id(entity.getId())
        .fullName(entity.getFullName())
        .departmentId(entity.getDepartment().getId())
        .build();
    }

    public static void updateEntity(Employee entity, EmployeeRequest request) {
        entity.setFullName(request.getFullName());
        entity.setPhone(request.getPhone());
        entity.setEmploymentStatus(request.getEmploymentStatus());
        entity.setHireDate(request.getHireDate());
        entity.setPosition(request.getPosition());
    }
}
