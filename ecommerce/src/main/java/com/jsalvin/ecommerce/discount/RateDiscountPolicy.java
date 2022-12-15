package com.jsalvin.ecommerce.discount;

import com.jsalvin.ecommerce.customer.Customer;
import com.jsalvin.ecommerce.customer.Grade;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercentage = 10;
    @Override
    public int discount(Customer customer, int price) {
        if (customer.getGrade() == Grade.VIP) {
            return price * discountPercentage / 100;
        } else {
            return 0;
        }
    }
}
