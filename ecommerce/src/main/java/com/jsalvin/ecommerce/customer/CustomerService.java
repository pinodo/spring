package com.jsalvin.ecommerce.customer;

public interface CustomerService {

    void join(Customer customer);

    Customer findCustomer(Long customerId);
}
