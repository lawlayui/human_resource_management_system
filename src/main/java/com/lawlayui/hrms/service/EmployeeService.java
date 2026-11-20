package com.lawlayui.hrms.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.EmployeeMapper;
import com.lawlayui.hrms.mapper.EmployeeSalaryMapper;
import com.lawlayui.hrms.persistence.entity.Department;
import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.persistence.entity.EmployeeSalary;
import com.lawlayui.hrms.persistence.entity.SalaryComponent;
import com.lawlayui.hrms.persistence.repository.DepartmentRepository;
import com.lawlayui.hrms.persistence.repository.EmployeeRepository;
import com.lawlayui.hrms.persistence.repository.EmployeeSalaryRepository;
import com.lawlayui.hrms.persistence.repository.SalaryComponentRepository;
import com.lawlayui.hrms.service.exception.DepartmentNotFoundException;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.validation.EmployeeRequest;
import com.lawlayui.hrms.validation.EmployeeResponse;
import com.lawlayui.hrms.validation.EmployeeResponseDetail;
import com.lawlayui.hrms.validation.EmployeeSalaryRequest;
import com.lawlayui.hrms.validation.EmployeeSalaryResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class EmployeeService {
    private final EmployeeRepository employeeRepository;    
    private final SalaryComponentRepository salaryComponentRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeSalaryRepository employeeSalaryRepository;

    public Page<EmployeeResponse> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable)
            .map(EmployeeMapper::entityToResponse);
    }

    public EmployeeResponseDetail getById(Integer id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
        return EmployeeMapper.entityToResponseDetail(employee);
    }

    public void create(EmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(() -> new DepartmentNotFoundException("Department with id " + request.getDepartmentId() + " not found"));
        Employee employee = EmployeeMapper.requestToEntity(request);
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void update(Integer id, EmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(() -> new DepartmentNotFoundException("Department with id " + request.getDepartmentId() + " not found"));
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
        employee.setDepartment(department);
        EmployeeMapper.updateEntity(employee, request);
        employeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeSalaryResponse> getEmployeeSalary(Integer employeeId) {
        return employeeSalaryRepository.findByEmployee_id(employeeId).stream()
            .map(EmployeeSalaryMapper::entityToResponse)
            .toList();
    }

    public void createEmployeeSalary(EmployeeSalaryRequest request) {
        EmployeeSalary entity = EmployeeSalaryMapper.requestToEntity(request);
        Employee employee = employeeRepository.findById(request.getEmployeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + request.getEmployeeId() + " not found"));
        SalaryComponent salaryComponent = salaryComponentRepository.findById(request.getSalaryComponentid())
            .orElseThrow(() -> new EmployeeNotFoundException("Salary component with id " + request.getSalaryComponentid() + " not found"));
        entity.setEmployee(employee);
        entity.setSalaryComponent(salaryComponent);
        employeeSalaryRepository.save(entity);
    }
}
