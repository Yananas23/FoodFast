package org.example;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println(FoodFastUtils.sumUpTo(5));

        DeliveryPlatform platform = new DeliveryPlatform();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            final int restaurantId = i;
            executor.submit(() -> {
                Customer customer = new Customer("c-" + restaurantId, "Customer " + restaurantId, "Address " + restaurantId);
                Dish dish = new Dish("Dish " + restaurantId, BigDecimal.valueOf(10 + restaurantId), Dish.DishSize.MEDIUM);
                Map<Dish, Integer> dishes = Map.of(dish, 1);
                Order order = new Order(Order.OrderStatus.PENDING, dishes, customer);
                platform.placeOrder(order);
                System.out.println("Placed order " + order.getId() + " by " + customer);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Total orders: " + platform.findOrdersByStatus(Order.OrderStatus.PENDING).size());
    }
}