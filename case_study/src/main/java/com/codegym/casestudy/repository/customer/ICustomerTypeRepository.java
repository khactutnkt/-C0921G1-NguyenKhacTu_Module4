package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
