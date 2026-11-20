package com.lawlayui.hrms.mapper;

import com.lawlayui.hrms.persistence.entity.SalaryComponent;
import com.lawlayui.hrms.validation.SalaryComponentRequest;
import com.lawlayui.hrms.validation.SalaryComponentResponse;

public class SalaryComponentMapper {
    public static SalaryComponentResponse entityToResponse(SalaryComponent entity) {
        return SalaryComponentResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .isPercentage(entity.getIsPercentage())
        .type(entity.getType())
        .value(entity.getDefaultValue())
        .build();
    }

    public static SalaryComponent requestToEntity(SalaryComponentRequest request) {
        return SalaryComponent.builder()
        .name(request.getName())
        .isPercentage(request.isPercentage())
        .defaultValue(request.getValue())
        .type(request.getType())
        .build();
    }
}
