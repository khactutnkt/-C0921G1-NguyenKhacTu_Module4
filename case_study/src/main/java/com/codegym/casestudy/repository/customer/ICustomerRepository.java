package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where customer_status=1;", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    Optional<Customer> findByCustomerId(Long customerId);

    @Query(value = "select * from customer where customer_name like %:customerNameSearch% and customer_type_id like %:customerTypeSearch%", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("customerNameSearch") String customerNameSearch,
                                  @Param("customerTypeSearch") String customerTypeSearch,
                                  Pageable pageable);

}
