package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
