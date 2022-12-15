package com.jsalvin.ecommerce.customer;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

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
}
