package com.jsalvin.ecommerce.discount;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% discount must apply to VIP customers")
    void vip_o() {
        //given
        Customer customer = new Customer(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(customer, 100);

        //then
        assertThat(discount).isEqualTo(10);
    }

    @Test
    @DisplayName("If not VIP members, discount should not be applied")
    void vip_x() {
        //given
        Customer customer = new Customer(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(customer, 100);

        //then
        assertThat(discount).isEqualTo(0);
    }
}