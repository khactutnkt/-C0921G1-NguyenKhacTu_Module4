package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository{
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(0, "T", "t@codegym.vn", "Da Nang"));
        customerList.add(new Customer(1, "Nhat", "nhat@codegym.vn", "Quang Tri"));
        customerList.add(new Customer(2, "Trang", "trang@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(3, "Nguyen Binh Son", "hoa@codegym.vn", "Sai Gon"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
