package com.jsalvin.ecommerce.autowired;

import com.jsalvin.ecommerce.AutoAppConfig;
import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.Grade;
import com.jsalvin.ecommerce.discount.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Customer customer = new Customer(1L, "customerA", Grade.VIP);
        int discountPrice = discountService.discount(customer, 100, "fixedDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1);

        int rateDiscountPrice = discountService.discount(customer, 100, "rateDiscountPolicy");
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Customer customer, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(customer, price);
        }
    }
}
