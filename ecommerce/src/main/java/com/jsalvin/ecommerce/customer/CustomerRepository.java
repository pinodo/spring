package com.jsalvin.ecommerce.customer;

public interface CustomerRepository {

    void save(Customer customer);

    Customer findById(Long customerId);
}
