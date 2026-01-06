package org.example;

import java.util.Map;
import java.util.Optional;

public class DeliveryPlatform {
     private Map<String, Order> orders;

     public void placeOrder(Order order) {
         orders.put(order.getId(), order);
     }

     public Optional<Order> findOrderById(String orderId) {
         return Optional.ofNullable(orders.get(orderId));
     }
}
