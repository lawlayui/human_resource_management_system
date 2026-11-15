package com.lawlayui.hrms.validation;

import java.time.LocalDateTime;

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
public class DepartmentResponse {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;
}
