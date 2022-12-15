package com.jsalvin.ecommerce.beanfind;

import com.jsalvin.ecommerce.AppConfig;
import com.jsalvin.ecommerce.customer.CustomerService;
import com.jsalvin.ecommerce.customer.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Search by bean name")
    void findBeanByName() {
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);
        assertThat(customerService).isInstanceOf(CustomerServiceImpl.class);
    }

    @Test
    @DisplayName("Search by type")
    void findBeanByType() {
        CustomerService customerService = ac.getBean(CustomerService.class);
        assertThat(customerService).isInstanceOf(CustomerServiceImpl.class);
    }

    @Test
    @DisplayName("Search by bean name - fail")
    void findBeanByNameX() {
//        CustomerService customerService = ac.getBean("xxxxx", CustomerService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", CustomerService.class));
    }
}
