package com.jsalvin.ecommerce.singleton;

import com.jsalvin.ecommerce.AppConfig;
import com.jsalvin.ecommerce.customer.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("w/o spring - pure DI container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        CustomerService customerService1 = appConfig.customerService();
        CustomerService customerService2 = appConfig.customerService();

        assertThat(customerService1).isNotSameAs(customerService2);
    }

    @Test
    @DisplayName("Singleton pattern")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("Spring container and singleton")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService1 = ac.getBean("customerService", CustomerService.class);
        CustomerService customerService2 = ac.getBean("customerService", CustomerService.class);

        assertThat(customerService1).isSameAs(customerService2);
    }
}
