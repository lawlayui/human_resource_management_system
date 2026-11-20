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

import com.lawlayui.hrms.service.SalaryComponentService;
import com.lawlayui.hrms.validation.SalaryComponentRequest;
import com.lawlayui.hrms.validation.SalaryComponentResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/salary-component")
@RequiredArgsConstructor 
public class SalaryComponentController {
    private final SalaryComponentService salaryComponentService;

    @PostMapping 
    public ResponseEntity<?> create(
        @RequestBody @Valid SalaryComponentRequest request
    ) {
        salaryComponentService.create(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<SalaryComponentResponse>> getAll(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<SalaryComponentResponse> result = salaryComponentService.getAll(pageable);
        return ResponseEntity.ok(result);
    }
}
