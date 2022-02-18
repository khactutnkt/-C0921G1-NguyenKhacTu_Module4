package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.CustomerType;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
