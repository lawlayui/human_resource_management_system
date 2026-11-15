package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}
