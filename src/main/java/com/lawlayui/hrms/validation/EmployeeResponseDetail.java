package com.lawlayui.hrms.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.lawlayui.hrms.persistence.entity.EmploymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Getter 
@Setter 
public class EmployeeResponseDetail {
    private Integer id;
    private String nik;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private EmploymentStatus employmentStatus;
    private Integer departmentId;
    private String position;
    private LocalDateTime createdAt; 
}
