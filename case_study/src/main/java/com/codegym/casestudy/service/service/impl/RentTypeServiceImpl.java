package com.codegym.casestudy.service.service.impl;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.repository.employee.IRentTypeRepository;
import com.codegym.casestudy.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
