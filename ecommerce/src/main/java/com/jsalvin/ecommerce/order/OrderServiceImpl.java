package com.jsalvin.ecommerce.order;

import com.jsalvin.ecommerce.annotation.MainDiscountPolicy;
import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.discount.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final CustomerRepository customerRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.customerRepository = customerRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long customerId, String itemName, int itemPrice) {
        Customer customer = customerRepository.findById(customerId);
        int discountPrice = discountPolicy.discount(customer, itemPrice);

        return new Order(customerId, itemName, itemPrice, discountPrice);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
