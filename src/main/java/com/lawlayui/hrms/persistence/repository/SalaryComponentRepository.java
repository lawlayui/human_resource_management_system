package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.SalaryComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryComponentRepository extends JpaRepository<SalaryComponent, Integer> {
}
