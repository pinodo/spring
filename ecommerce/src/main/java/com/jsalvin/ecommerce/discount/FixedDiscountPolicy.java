package com.jsalvin.ecommerce.discount;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixedAmount = 1;

    @Override
    public int discount(Customer customer, int price) {
        if (customer.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
