package com.jsalvin.ecommerce;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.CustomerService;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import com.jsalvin.ecommerce.customer.Grade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        CustomerService customerService = appConfig.customerService();
//        CustomerService customerService = new CustomerServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        Customer customer = new Customer(1L, "customer1", Grade.VIP);
        customerService.join(customer);

        Customer findCustomer = customerService.findCustomer(1L);
        System.out.println("new customer = " + customer.getName());
        System.out.println("find customer = " + findCustomer.getName());
    }
}
