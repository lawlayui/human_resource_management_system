package com.lawlayui.hrms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.hrms.service.AttendanceService;
import com.lawlayui.hrms.validation.AttendanceClockInRequest;
import com.lawlayui.hrms.validation.AttendanceClockOutRequest;
import com.lawlayui.hrms.validation.AttendanceResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/api/attendances")
public class AttendanceController {
    public final AttendanceService service;

    @GetMapping
    public ResponseEntity<Page<AttendanceResponse>> getAll(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size, 
        @RequestParam(defaultValue = "employeeId") String sortBy,
        @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<AttendanceResponse> result = service.getAll(pageable);
        return ResponseEntity.ok(result);
    }

    @PostMapping 
    public ResponseEntity<?> clockIn(
        @RequestBody @Valid AttendanceClockInRequest request
    ) {
        service.clock_in(request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping 
    public ResponseEntity<?> clockOut(
        @RequestBody @Valid AttendanceClockOutRequest request
    ) {
        service.clock_out(request);
        return ResponseEntity.noContent().build();
    }
}
