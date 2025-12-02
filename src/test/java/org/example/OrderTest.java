package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderTest {
    @Test
    public void testGetter() {

        Order order = new Order(Order.OrderStatus.PENDING, null, null);

        assert order.getId() != null;
    }
}
