package com.lawlayui.hrms.validation;

import java.time.LocalDate;

import com.lawlayui.hrms.persistence.entity.LeaveType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Setter 
@Getter 
public class LeaveRequestDto {
    @NotNull 
    private Integer employeeId;
    @NotNull 
    private LeaveType leaveType;
    @NotNull 
    private LocalDate startDate;
    @NotNull 
    private LocalDate endDate;
    @NotBlank 
    private String reason;
    @NotBlank 
    private String attachmentUrl;
}
