package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.repository.customer.ICustomerRepro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepro customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }
}
