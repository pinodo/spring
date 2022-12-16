package com.jsalvin.ecommerce.singleton;

import com.jsalvin.ecommerce.AppConfig;
import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import com.jsalvin.ecommerce.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerServiceImpl customerService = ac.getBean("customerService", CustomerServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        CustomerRepository customerRepository = ac.getBean("customerRepository", CustomerRepository.class);

        CustomerRepository customerRepository1 = customerService.getCustomerRepository();
        CustomerRepository customerRepository2 = orderService.getCustomerRepository();

        Assertions.assertThat(customerRepository1).isSameAs(customerRepository2);
        Assertions.assertThat(customerRepository1).isSameAs(customerRepository);
        //result: customerRepository = customerRepository1 = customerRepository2
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

//        System.out.println(bean); //classname$$SpringCGLIB$$...

    }
}
