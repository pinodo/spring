package com.jsalvin.ecommerce.customer;

import com.jsalvin.ecommerce.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    CustomerService customerService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        customerService = appConfig.customerService();
    }

    @Test
    void join() {
        //given
        Customer customer = new Customer(1L, "customer1", Grade.VIP);

        //when
        customerService.join(customer);
        Customer findCustomer = customerService.findCustomer(1L);

        //then
        Assertions.assertThat(customer).isEqualTo(findCustomer);
    }
}
