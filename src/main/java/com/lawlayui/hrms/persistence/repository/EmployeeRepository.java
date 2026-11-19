package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
