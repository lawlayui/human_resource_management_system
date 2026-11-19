package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.LeaveRequest;
import com.lawlayui.hrms.validation.LeaveRequestDto;
import com.lawlayui.hrms.validation.LeaveRequestResponse;
import com.lawlayui.hrms.validation.LeaveRequestResponseDetail;

public class LeaveRequestMapper {
    public static LeaveRequest requestToEntity(LeaveRequestDto dto) {
        return LeaveRequest.builder()
        .leaveType(dto.getLeaveType())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .reason(dto.getReason())
        .attachmentUrl(dto.getAttachmentUrl())
        .build();
    }

    public static LeaveRequestResponse entityToResponse (LeaveRequest leaveRequest) {
        return LeaveRequestResponse.builder()
        .id(leaveRequest.getId())
        .employeeId(leaveRequest.getEmployee().getId())
        .status(leaveRequest.getStatus())
        .build();
    }

    public static LeaveRequestResponseDetail entityToResponseDetail(LeaveRequest leaveRequest) {
        return LeaveRequestResponseDetail.builder()
        .id(leaveRequest.getId())
        .employeeId(leaveRequest.getEmployee().getId())
        .leaveType(leaveRequest.getLeaveType())
        .starDate(leaveRequest.getStartDate())
        .endDate(leaveRequest.getEndDate())
        .reason(leaveRequest.getReason())
        .attachmentUrl(leaveRequest.getAttachmentUrl())
        .status(leaveRequest.getStatus())
        .approvedBy(leaveRequest.getApprovedBy().getId())
        .createdAt(leaveRequest.getCreatedAt())
        .build();
    }
}
