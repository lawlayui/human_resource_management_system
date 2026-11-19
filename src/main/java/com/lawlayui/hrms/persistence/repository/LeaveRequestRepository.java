package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
}
