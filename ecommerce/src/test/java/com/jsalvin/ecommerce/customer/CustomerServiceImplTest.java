package com.jsalvin.ecommerce.customer;

import com.jsalvin.ecommerce.discount.FixedDiscountPolicy;
import com.jsalvin.ecommerce.order.Order;
import com.jsalvin.ecommerce.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @Test
    void createOrder() {
        MemoryCustomerRepository customerRepository = new MemoryCustomerRepository();
        customerRepository.save(new Customer(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryCustomerRepository(), new FixedDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 100);
        assertThat(order.getDiscountPrice()).isEqualTo(1);
    }
}