package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.PayrollRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRunRepository extends JpaRepository<PayrollRun, Integer> {
}
