package com.jsalvin.ecommerce;

import com.jsalvin.ecommerce.customer.CustomerRepository;
import com.jsalvin.ecommerce.customer.MemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*
    @Bean(name = "memoryCustomerRepository")
    CustomerRepository customerRepository() {
        return new MemoryCustomerRepository();
    }
 */
}
