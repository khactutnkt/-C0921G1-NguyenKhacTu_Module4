package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
