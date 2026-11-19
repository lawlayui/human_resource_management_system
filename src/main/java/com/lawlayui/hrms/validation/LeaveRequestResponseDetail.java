package com.lawlayui.hrms.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.lawlayui.hrms.persistence.entity.LeaveRequestStatus;
import com.lawlayui.hrms.persistence.entity.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class LeaveRequestResponseDetail {
    private Integer id;
    private Integer employeeId;
    private LeaveType leaveType;
    private LocalDate starDate;
    private LocalDate endDate;
    private String reason;
    private String attachmentUrl;
    private LeaveRequestStatus status;
    private Integer approvedBy;
    private LocalDateTime createdAt;
}
