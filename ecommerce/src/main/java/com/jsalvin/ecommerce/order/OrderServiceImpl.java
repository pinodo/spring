package com.jsalvin.ecommerce.order;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.customer.MemoryCustomerRepository;
import com.jsalvin.ecommerce.discount.DiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final CustomerRepository customerRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(CustomerRepository customerRepository, DiscountPolicy discountPolicy) {
        this.customerRepository = customerRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long customerId, String itemName, int itemPrice) {
        Customer customer = customerRepository.findById(customerId);
        int discountPrice = discountPolicy.discount(customer, itemPrice);

        return new Order(customerId, itemName, itemPrice, discountPrice);
    }
}
