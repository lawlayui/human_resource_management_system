package com.lawlayui.hrms.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.PayslipMapper;
import com.lawlayui.hrms.persistence.entity.Employee;
import com.lawlayui.hrms.persistence.entity.EmployeeSalary;
import com.lawlayui.hrms.persistence.entity.PayrollRun;
import com.lawlayui.hrms.persistence.entity.PayrollStatus;
import com.lawlayui.hrms.persistence.entity.Payslip;
import com.lawlayui.hrms.persistence.entity.SalaryComponentType;
import com.lawlayui.hrms.persistence.repository.EmployeeRepository;
import com.lawlayui.hrms.persistence.repository.PayrollRunRepository;
import com.lawlayui.hrms.persistence.repository.PayslipRepository;
import com.lawlayui.hrms.service.exception.EmployeeNotFoundException;
import com.lawlayui.hrms.validation.PayslipResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class PayslipService {
    private PayslipRepository payslipRepository;
    private PayrollRunRepository payrollRunRepository;
    private EmployeeRepository employeeRepository;

    public void calculate(Integer payrollRunId) {
        PayrollRun payrollRun = payrollRunRepository.findByIdAndStatus(payrollRunId, PayrollStatus.approved)
            .orElseThrow(() -> new EmployeeNotFoundException("Payroll with id " + payrollRunId + " not found"));
        List<Employee> employees = employeeRepository.findAll();
        
        for (Employee employee : employees) {
            Payslip payslip = Payslip.builder().build();
            BigDecimal earning = BigDecimal.ZERO;
            BigDecimal totalDeductions = BigDecimal.ZERO;
            for (EmployeeSalary employeeSalary : employee.getEmployeeSalaries()) {
                if (employeeSalary.getSalaryComponent().getType().name().equals(SalaryComponentType.earning.name())) {
                    earning.add(employeeSalary.getSalaryComponent().getDefaultValue());
                } else {
                    totalDeductions.add(employeeSalary.getSalaryComponent().getDefaultValue());
                };
            }
            payslip.setGrossSalary(earning);
            payslip.setTakeHomePay(payslip.getGrossSalary().subtract(totalDeductions));
            payslip.setPayrollRun(payrollRun);
            payslip.setEmployee(employee);
            payslip.setCreatedAt(LocalDateTime.now());
            payslipRepository.save(payslip);
        }

        payrollRun.setStatus(PayrollStatus.paid);
    }

    public Page<PayslipResponse> getAll(Pageable pageable) {
        return payslipRepository.findAll(pageable)
            .map(PayslipMapper::entityToResponse);
    }
}
