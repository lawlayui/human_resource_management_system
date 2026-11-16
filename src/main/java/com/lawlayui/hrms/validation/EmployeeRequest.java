package com.lawlayui.hrms.validation;

import java.time.LocalDate;

import com.lawlayui.hrms.persistence.entity.EmploymentStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder 
@Getter 
@Setter 
public class EmployeeRequest {
    @NotBlank 
    private String nik;

    @NotBlank 
    private String fullName;

    @Email 
    @NotBlank 
    private String email;

    @NotBlank 
    @Pattern(
        regexp = "^(\\+62|62|0)8[1-9][0-9]{7,11}$",
        message = "The mobile phone number format is incorrect."
    )
    private String phone;

    private LocalDate hireDate;
    private EmploymentStatus employmentStatus;
    private Integer departmentId;

    @NotBlank 
    private String position;
}
