package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {
}
