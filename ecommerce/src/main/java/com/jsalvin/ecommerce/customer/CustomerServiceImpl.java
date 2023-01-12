package com.jsalvin.ecommerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void join(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomer(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
