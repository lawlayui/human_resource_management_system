package com.lawlayui.hrms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.DepartmentMapper;
import com.lawlayui.hrms.persistence.entity.Department;
import com.lawlayui.hrms.persistence.repository.DepartmentRepository;
import com.lawlayui.hrms.validation.DepartmentRequest;
import com.lawlayui.hrms.validation.DepartmentResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Page<DepartmentResponse> getAll(Pageable pageable) {
        return departmentRepository.findAll(pageable)       
            .map(DepartmentMapper::toResponse);
    }

    public void createDepartment(DepartmentRequest request) {
        Department department = Department.builder().name(request.getName()).build();

        departmentRepository.save(department);
    }
}
