package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.CustomerType;
import org.springframework.stereotype.Service;


public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
