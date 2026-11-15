package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.Department;
import com.lawlayui.hrms.validation.DepartmentResponse;

public class DepartmentMapper {
    public static DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
        .id(department.getId())
        .name(department.getName())
        .createdAt(department.getCreatedAt())
        .build();
    }
}
