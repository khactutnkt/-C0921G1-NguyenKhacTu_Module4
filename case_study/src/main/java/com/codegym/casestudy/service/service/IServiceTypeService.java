package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.ServiceType;

public interface IServiceTypeService {
    Iterable<ServiceType> findAll();
}
