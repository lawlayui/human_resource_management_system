package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer> {
}
