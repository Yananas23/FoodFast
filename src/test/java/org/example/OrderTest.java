package org.example;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testGetter() {
        Order order = new Order();
        order.setId(1);
        order.setDescription("Test Order");

        assert order.getId() == 1;
        assert order.getDescription().equals("Test Order");
    }
}
