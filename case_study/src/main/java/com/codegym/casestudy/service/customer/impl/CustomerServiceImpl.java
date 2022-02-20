package com.codegym.casestudy.service.customer.impl;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public void delete(Customer customer) {
        customer.setCustomerStatus("0");
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String customerNameSearch, String customerTypeSearch, Pageable pageable) {
        return customerRepository.searchCustomer(customerNameSearch, customerTypeSearch, pageable);
    }


}
