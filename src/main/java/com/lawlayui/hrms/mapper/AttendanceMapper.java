package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.Attendance;
import com.lawlayui.hrms.validation.AttendanceResponse;

public class AttendanceMapper {
    public static AttendanceResponse entityToResponse(Attendance entity) {
        return AttendanceResponse.builder()
        .id(entity.getId())
        .employeeId(entity.getEmployee().getId())
        .date(entity.getDate())
        .clockIn(entity.getClockIn())
        .clockOut(entity.getClockOut())
        .status(entity.getStatus())
        .build();
    }
}
