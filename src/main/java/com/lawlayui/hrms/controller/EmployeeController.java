package com.lawlayui.hrms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.hrms.service.EmployeeService;
import com.lawlayui.hrms.validation.EmployeeRequest;
import com.lawlayui.hrms.validation.EmployeeResponse;
import com.lawlayui.hrms.validation.EmployeeResponseDetail;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/employees")
@RequiredArgsConstructor 
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> getAll(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size, 
        @RequestParam(defaultValue = "departmentId") String sortBy,
        @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<EmployeeResponse> result = employeeService.getAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDetail> getById(
        @PathVariable Integer id
    ) {
        EmployeeResponseDetail result = employeeService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(
        @RequestBody EmployeeRequest request
    ) {
        employeeService.create(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
        @PathVariable Integer id,
        @RequestBody  EmployeeRequest request
    ) {
        employeeService.update(id, request);
        return ResponseEntity.noContent().build();
    }
}
