package com.lawlayui.hrms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lawlayui.hrms.mapper.SalaryComponentMapper;
import com.lawlayui.hrms.persistence.entity.SalaryComponent;
import com.lawlayui.hrms.persistence.repository.SalaryComponentRepository;
import com.lawlayui.hrms.validation.SalaryComponentRequest;
import com.lawlayui.hrms.validation.SalaryComponentResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class SalaryComponentService {
    private final SalaryComponentRepository salaryComponentRepository;

    public Page<SalaryComponentResponse> getAll(Pageable pageable) {
        return salaryComponentRepository.findAll(pageable)
            .map(SalaryComponentMapper::entityToResponse);
    }

    public void create(SalaryComponentRequest request) {
        SalaryComponent entity = SalaryComponentMapper.requestToEntity(request);
        salaryComponentRepository.save(entity);
    }
}
