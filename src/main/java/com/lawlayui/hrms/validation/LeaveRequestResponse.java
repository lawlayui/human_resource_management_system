package com.lawlayui.hrms.validation;

import com.lawlayui.hrms.persistence.entity.LeaveRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Setter 
@Getter 
public class LeaveRequestResponse {
    private Integer id;
    private Integer employeeId;
    private LeaveRequestStatus status;
}
