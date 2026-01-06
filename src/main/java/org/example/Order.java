package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
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
    
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", dishes=" + dishes +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }
}
