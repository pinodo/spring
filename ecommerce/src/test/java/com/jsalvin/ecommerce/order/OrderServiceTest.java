package com.jsalvin.ecommerce.order;

import com.jsalvin.ecommerce.AppConfig;
import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.CustomerService;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import com.jsalvin.ecommerce.customer.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    CustomerService customerService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        customerService = appConfig.customerService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long customerId = 1L;
        Customer customer = new Customer(customerId, "customerA", Grade.VIP);
        customerService.join(customer);

        Order order = orderService.createOrder(customerId, "itemA", 100);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1);
    }
}
