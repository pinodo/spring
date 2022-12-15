package com.jsalvin.ecommerce.beanfind;

import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.customer.MemoryCustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("If there are duplicates, duplication error occurs")
    void findBeanByTypeDuplicate() {
        CustomerRepository bean = ac.getBean(CustomerRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(CustomerRepository.class));
    }

    @Test
    @DisplayName("If there are duplicates, designate the bean name")
    void findBeanByName() {
        CustomerRepository customerRepository = ac.getBean("customerRepository1", CustomerRepository.class);
        assertThat(customerRepository).isInstanceOf(CustomerRepository.class);
    }

    @Test
    @DisplayName("Search all the specific type")
    void findAllBeanByType() {
        Map<String, CustomerRepository> beansOfType = ac.getBeansOfType(CustomerRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " / value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public CustomerRepository customerRepository1() {
            return new MemoryCustomerRepository();
        }

        @Bean
        public CustomerRepository customerRepository2() {
            return new MemoryCustomerRepository();
        }
    }
}
