package com.codegym.casestudy.service.service.impl;

import com.codegym.casestudy.model.ServiceType;
import com.codegym.casestudy.repository.employee.IServiceTypeRepository;
import com.codegym.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
