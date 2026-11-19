package com.lawlayui.hrms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.hrms.service.LeaveRequestService;
import com.lawlayui.hrms.validation.LeaveRequestDecisionRequest;
import com.lawlayui.hrms.validation.LeaveRequestDto;
import com.lawlayui.hrms.validation.LeaveRequestResponse;
import com.lawlayui.hrms.validation.LeaveRequestResponseDetail;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/leave-request")
@RequiredArgsConstructor 
public class LeaveRequestController {
    private final LeaveRequestService service;

    @PostMapping 
    public ResponseEntity<?> create(
        @RequestBody @Valid LeaveRequestDto requestDto
    ) {
        service.create(requestDto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{employee_id}/decision")
    public ResponseEntity<?> decision(
        @PathVariable Integer employee_id,
        @RequestBody @Valid LeaveRequestDecisionRequest request
    ) {
        service.decision(employee_id, request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping 
    public ResponseEntity<Page<LeaveRequestResponse>> getAll(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "status") String sortBy,
        @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<LeaveRequestResponse> result = service.getAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestResponseDetail> getById(
        @PathVariable Integer id
    ) {
        LeaveRequestResponseDetail result = service.getById(id);
        return ResponseEntity.ok(result);
    }
}
