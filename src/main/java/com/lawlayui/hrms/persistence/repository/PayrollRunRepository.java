package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.PayrollRun;
import com.lawlayui.hrms.persistence.entity.PayrollStatus;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRunRepository extends JpaRepository<PayrollRun, Integer> {
    Optional<PayrollRun> findByIdAndStatus(Integer id, PayrollStatus payrollStatus);
}
