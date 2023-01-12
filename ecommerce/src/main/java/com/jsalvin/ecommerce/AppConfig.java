package com.jsalvin.ecommerce;

import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.customer.CustomerService;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import com.jsalvin.ecommerce.customer.MemoryCustomerRepository;
import com.jsalvin.ecommerce.discount.DiscountPolicy;
import com.jsalvin.ecommerce.discount.FixedDiscountPolicy;
import com.jsalvin.ecommerce.discount.RateDiscountPolicy;
import com.jsalvin.ecommerce.order.OrderService;
import com.jsalvin.ecommerce.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl(customerRepository());
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new MemoryCustomerRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(customerRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixedDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
