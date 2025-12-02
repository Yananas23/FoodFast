package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String id;
    private OrderStatus status;
    private Map<Dish, Integer> dishes;
    private Customer customer;
    private LocalDateTime orderDate;

    public String getId() {
        return id;
    }

    public enum OrderStatus {
        PENDING, IN_PREPARATION, COMPLETED, CANCELLED
    }

    public Order(OrderStatus status, Map<Dish, Integer> dishes, Customer customer) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.dishes = dishes;
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
    }

    public BigDecimal calculateTotalPrice() {
        return dishes.entrySet().stream()
                .map(entry -> entry.getKey().getPrice()
                .multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
