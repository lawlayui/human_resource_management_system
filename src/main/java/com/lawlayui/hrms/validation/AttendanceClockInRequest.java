package com.lawlayui.hrms.validation;

import java.time.LocalDate;
import java.time.LocalTime;

import com.lawlayui.hrms.persistence.entity.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class AttendanceClockInRequest {
    @NotNull 
    private Integer employeeId; 

    @NotNull 
    private LocalDate date; 

    @NotNull 
    private LocalTime clockIn; 

    @NotNull 
    private AttendanceStatus status;
}
