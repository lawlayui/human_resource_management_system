package com.lawlayui.hrms.validation;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class AttendanceClockOutRequest {
    @NotNull 
    private Integer employeeId;

    @NotNull 
    private LocalDate date;

    @NotNull
    private LocalTime clockOut;
}
