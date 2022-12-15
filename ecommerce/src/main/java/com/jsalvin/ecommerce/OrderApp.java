package com.jsalvin.ecommerce;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.CustomerService;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import com.jsalvin.ecommerce.customer.Grade;
import com.jsalvin.ecommerce.discount.DiscountPolicy;
import com.jsalvin.ecommerce.order.Order;
import com.jsalvin.ecommerce.order.OrderService;
import com.jsalvin.ecommerce.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        CustomerService customerService = appConfig.customerService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        CustomerService customerService = new CustomerServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        Long customerId = 1L;
        Customer customer = new Customer(customerId, "customerA", Grade.VIP);
        customerService.join(customer);

        Order order = orderService.createOrder(customerId, "itemA", 100);

        System.out.println("Order = " + order);
    }
}
