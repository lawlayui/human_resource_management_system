package com.lawlayui.hrms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.AttendanceMapper;
import com.lawlayui.hrms.persistence.entity.Attendance;
import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.persistence.repository.AttendanceRepository;
import com.lawlayui.hrms.persistence.repository.EmployeeRepository;
import com.lawlayui.hrms.service.exception.AttendanceNotFoundException;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.validation.AttendanceClockInRequest;
import com.lawlayui.hrms.validation.AttendanceClockOutRequest;
import com.lawlayui.hrms.validation.AttendanceResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public Page<AttendanceResponse> getAll(Pageable pageable) {
        return attendanceRepository.findAll(pageable)
            .map(AttendanceMapper::entityToResponse);
    }

    public void clock_in(AttendanceClockInRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + request.getEmployeeId() + " not found"));
        Attendance attendance = Attendance.builder()
        .clockIn(request.getClockIn())
        .date(request.getDate())
        .employee(employee)
        .status(request.getStatus())
        .build();
        attendanceRepository.save(attendance);
    }

    public void clock_out(AttendanceClockOutRequest request) {
        Attendance attendance = attendanceRepository.findByDateAndEmployee_id(request.getDate(), request.getEmployeeId())
            .orElseThrow(() -> new AttendanceNotFoundException("Attendance with date " + request.getDate() + " and employee id " + request.getEmployeeId() + " not found"));
        attendance.setClockOut(request.getClockOut());
        attendanceRepository.save(attendance);
    }
}
