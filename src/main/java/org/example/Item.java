package org.example;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String name;
    private double price;

    public Item() {
        this.name = "";
        this.price = 0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        return (int) (this.name.compareTo(o.name) * 100
                        + this.price - o.price);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(price, item.price) == 0 && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
