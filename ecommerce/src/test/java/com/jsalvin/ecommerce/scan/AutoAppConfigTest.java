package com.jsalvin.ecommerce.scan;

import com.jsalvin.ecommerce.AutoAppConfig;
import com.jsalvin.ecommerce.customer.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        CustomerService customerService = ac.getBean(CustomerService.class);
        assertThat(customerService).isInstanceOf(CustomerService.class);
    }
}
