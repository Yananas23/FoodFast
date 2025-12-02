package org.example;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testGetter() {

        Order order = new Order(Order.OrderStatus.PENDING, null, null);
        
        assert order.getId() != null;
        assert order.getStatus() == Order.OrderStatus.PENDING;
        assert order.getDishes() == null;
        assert order.getCustomer() == null;
        assert order.getOrderDate() != null;
    }

    @Test
    public void testEquals() {
        Order order1 = new Order(Order.OrderStatus.PENDING, null, null);
        Order order2 = new Order(Order.OrderStatus.PENDING, null, null);

        assert !order1.equals(order2);
    }

    @Test
    public void testHashCode() {
        Order order1 = new Order(Order.OrderStatus.PENDING, null, null);
        Order order2 = new Order(Order.OrderStatus.PENDING, null, null);

        assert order1.hashCode() != order2.hashCode();
    }

    @Test
    public void testToString() {
        Order order = new Order(Order.OrderStatus.PENDING, null, null);
        String toString = order.toString();

        assert toString.contains("Order");
        assert toString.contains("id='");
        assert toString.contains("status=");
        assert toString.contains("dishes=");
        assert toString.contains("customer=");
        assert toString.contains("orderDate=");
    }
}