package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.LeaveBalance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {
    Optional<LeaveBalance> findByEmployee_idAndYear(Integer id, Integer year);
}
