package com.lawlayui.hrms.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Builder
@Getter 
@Setter 
public class LeaveRequestDecisionRequest {
    @NotBlank 
    private String decision;
    @NotNull 
    private Integer apporovedby;
}
