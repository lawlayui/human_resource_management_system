package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayslipRepository extends JpaRepository<Payslip, Integer> {
}
