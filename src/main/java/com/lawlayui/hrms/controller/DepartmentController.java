package com.lawlayui.hrms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.hrms.service.DepartmentService;
import com.lawlayui.hrms.validation.DepartmentRequest;
import com.lawlayui.hrms.validation.DepartmentResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api")
@RequiredArgsConstructor 
public class DepartmentController {
    private final DepartmentService departementService;

    @GetMapping("/departments")
    public ResponseEntity<Page<DepartmentResponse>> getAll(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size, 
        @RequestParam(defaultValue = "id") String sortBy, 
        @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());

        Sort sort = Sort.by(sortDirection, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<DepartmentResponse> result = departementService.getAll(pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/departments")
    public ResponseEntity<?> createDepartment(
        @RequestBody @Valid DepartmentRequest request
    ) {
        departementService.createDepartment(request);

        return ResponseEntity.noContent().build();
    }
}
