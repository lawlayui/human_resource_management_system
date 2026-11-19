package com.lawlayui.hrms.service;

import com.lawlayui.hrms.persistence.repository.LeaveBalanceRepository;
import java.time.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.LeaveRequestMapper;
import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.persistence.entity.LeaveBalance;
import com.lawlayui.hrms.persistence.entity.LeaveRequest;
import com.lawlayui.hrms.persistence.entity.LeaveRequestStatus;
import com.lawlayui.hrms.persistence.repository.EmployeeRepository;
import com.lawlayui.hrms.persistence.repository.LeaveRequestRepository;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.service.exception.InvalidLeaveRequestException;
import com.lawlayui.hrms.service.exception.LeaveBalanceNotFoundException;
import com.lawlayui.hrms.service.exception.LeaveRequestNotFoundException;
import com.lawlayui.hrms.validation.LeaveRequestDecisionRequest;
import com.lawlayui.hrms.validation.LeaveRequestDto;
import com.lawlayui.hrms.validation.LeaveRequestResponse;
import com.lawlayui.hrms.validation.LeaveRequestResponseDetail;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class LeaveRequestService {
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    public void create(LeaveRequestDto requestDto) {
        Employee employee = employeeRepository.findById(requestDto.getEmployeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + requestDto.getEmployeeId() + " not found"));
        LeaveBalance leaveBalance = leaveBalanceRepository.findByEmployee_idAndYear(requestDto.getEmployeeId(), requestDto.getStartDate().getYear())
            .orElseThrow(() -> new LeaveBalanceNotFoundException("Leave balance with employee id " + requestDto.getEmployeeId() + " not found"));
        LeaveRequest leaveRequest = LeaveRequestMapper.requestToEntity(requestDto);
        leaveRequest.setEmployee(employee);
        Integer day = Period.between(requestDto.getStartDate(), requestDto.getEndDate()).getDays();
        if (leaveBalance.getTotalQuota() < day) {
            throw new InvalidLeaveRequestException("Leave request exceeds the limit.");
        }
        leaveBalance.setTotalQuota(leaveBalance.getTotalQuota() - day);
        leaveBalance.setUsedQuota(leaveBalance.getUsedQuota() + day);
        leaveBalanceRepository.save(leaveBalance);
        leaveRequestRepository.save(leaveRequest);
    }

    public Page<LeaveRequestResponse> getAll(Pageable pageable) {
        return leaveRequestRepository.findAll(pageable)
            .map(LeaveRequestMapper::entityToResponse);
    }

    public LeaveRequestResponseDetail getById(Integer id) {
        LeaveRequest result = leaveRequestRepository.findById(id)
            .orElseThrow(() -> new LeaveRequestNotFoundException("Leave request with id " + id + " not found"));
        return LeaveRequestMapper.entityToResponseDetail(result);
    }

    public void decision(Integer id, LeaveRequestDecisionRequest request) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
            .orElseThrow(() -> new LeaveRequestNotFoundException("Leave request with id " + id + " not found"));
        Employee employee = employeeRepository.findById(request.getApporovedby())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + request.getApporovedby() + " not found"));
        leaveRequest.setApprovedBy(employee);
        if (request.getDecision().equals("approved")) {
            leaveRequest.setStatus(LeaveRequestStatus.approved);
            leaveRequestRepository.save(leaveRequest);
        } else {
            leaveRequest.setStatus(LeaveRequestStatus.rejected);
            leaveRequestRepository.save(leaveRequest);
        }
    }
}
