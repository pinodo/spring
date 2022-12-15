package com.jsalvin.ecommerce.discount;

import com.jsalvin.ecommerce.customer.Customer;

public interface DiscountPolicy {

    /**
     * @return discount target price
     */
    int discount(Customer customer, int price);
}
