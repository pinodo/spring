package com.jsalvin.ecommerce.order;

public interface OrderService {
    Order createOrder(Long customerId, String itemName, int itemPrice);
}
