package com.lawlayui.hrms.validation;

import java.time.LocalDate;
import java.time.LocalTime;

import com.lawlayui.hrms.persistence.entity.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class AttendanceResponse {
    private Integer id; 
    private Integer employeeId; 
    private LocalDate date; 
    LocalTime clockIn; 
    LocalTime clockOut;
    private AttendanceStatus status;
}
