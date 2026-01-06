package org.example;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.example.Order.OrderStatus;

public class DeliveryPlatform {
     private final ConcurrentMap<String, Order> orders = new ConcurrentHashMap<>();

     public void placeOrder(Order order) {
        try {
            Restaurant restaurant = new Restaurant();
            restaurant.prepareOrder(order);
        } catch (OrderPreparationException e) {
            order.setStatus(OrderStatus.CANCELLED);
            return;
        }
         orders.put(order.getId(), order);
     }

     public Optional<Order> findOrderById(String orderId) {
         return Optional.ofNullable(orders.get(orderId));
     }

     public List<Order> findOrdersByCustomer(Customer customer) {
            return orders.values().stream()
                    .filter(order -> order.getCustomer().equals(customer))
                    .toList();
     }

     public List<Order> findOrdersByStatus(OrderStatus status) {
            return orders.values().stream()
                    .filter(order -> order.getStatus() == status)
                    .toList();
     }
}
