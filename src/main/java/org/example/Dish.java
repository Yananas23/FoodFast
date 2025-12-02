package org.example;
import java.math.BigDecimal;
import java.util.Objects;


public class Dish {
    private String name;
    private BigDecimal price;
    private DishSize size;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DishSize getSize() {
        return size;
    }

    public enum DishSize {
        SMALL, MEDIUM, LARGE
    }

    public Dish(String name, BigDecimal price, DishSize size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(price, dish.price) &&
                size == dish.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, size);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}