package com.lawlayui.hrms.service;

import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.LeaveBalanceMapper;
import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.persistence.entity.LeaveBalance;
import com.lawlayui.hrms.persistence.repository.EmployeeRepository;
import com.lawlayui.hrms.persistence.repository.LeaveBalanceRepository;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.service.exception.LeaveBalanceNotFoundException;
import com.lawlayui.hrms.validation.LeaveBalanceRequest;
import com.lawlayui.hrms.validation.LeaveBalanceResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class LeaveBalanceService {
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveBalanceResponse getByEmployeeIdAndYear(Integer id, Integer year) {
        LeaveBalance result = leaveBalanceRepository.findByEmployee_idAndYear(id, year)
            .orElseThrow(() -> new LeaveBalanceNotFoundException("Leave balance with employee id " + id + " and year " + year + " not found"));
        
        return LeaveBalanceMapper.entityToResponse(result);
    }

    public void create(LeaveBalanceRequest request) {
        LeaveBalance entity = LeaveBalanceMapper.requestToEntity(request);
        Employee employee = employeeRepository.findById(request.getEmployeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + request.getEmployeeId() + " not found"));
        entity.setEmployee(employee);
        leaveBalanceRepository.save(entity);
    }
}
