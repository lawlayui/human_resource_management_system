package com.lawlayui.hrms.persistence.repository;

import com.lawlayui.hrms.persistence.entity.Attendance;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    Optional<Attendance> findByDateAndEmployee_id(LocalDate date, Integer id);
}
