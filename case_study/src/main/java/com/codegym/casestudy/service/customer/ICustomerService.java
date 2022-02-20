package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);
    void save(Customer customer);
    Optional<Customer> findByCustomerId(Long customerId);
    void delete(Customer customer);

    Page<Customer> searchCustomer(String customerNameSearch, String customerTypeSearch, Pageable pageable);

}
