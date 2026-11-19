package com.lawlayui.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.hrms.service.LeaveBalanceService;
import com.lawlayui.hrms.validation.LeaveBalanceRequest;
import com.lawlayui.hrms.validation.LeaveBalanceResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/leave-balance")
@RequiredArgsConstructor 
public class LeaveBalanceController {
    private final LeaveBalanceService leaveBalanceService;

    @GetMapping("/{employee_id}")
    public ResponseEntity<LeaveBalanceResponse> getByEmployeeId(
        @PathVariable Integer employee_id,
        @RequestParam(defaultValue = "2026") Integer year
    ) {
        LeaveBalanceResponse result = leaveBalanceService.getByEmployeeIdAndYear(employee_id, year);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(
        @RequestBody @Valid LeaveBalanceRequest request
    ) {
        leaveBalanceService.create(request);
        return ResponseEntity.noContent().build();
    }
}
