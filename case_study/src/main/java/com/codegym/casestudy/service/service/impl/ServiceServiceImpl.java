package com.codegym.casestudy.service.service.impl;

import com.codegym.casestudy.repository.employee.IServiceRepository;
import com.codegym.casestudy.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public void save(com.codegym.casestudy.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<com.codegym.casestudy.model.Service> findAllService(Pageable pageable) {
        return serviceRepository.getAllService(pageable);
    }
}
