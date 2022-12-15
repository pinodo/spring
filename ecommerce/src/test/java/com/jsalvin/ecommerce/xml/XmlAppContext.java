package com.jsalvin.ecommerce.xml;

import com.jsalvin.ecommerce.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);
        assertThat(customerService).isInstanceOf(CustomerService.class);

    }
}
