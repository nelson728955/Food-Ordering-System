package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Order {
    protected int orderNumber;
    protected String orderStatus;
    protected List<Item> items;
    protected LocalDateTime timeCreated;

    private static int nextOrderNumber = 0;

    public Order() {
        this.orderNumber = nextOrderNumber++;
        this.orderStatus = "";
        this.items = new ArrayList<>();
        this.timeCreated = LocalDateTime.now();
    }

    public Order(String orderStatus, List<Item> items) {
        this.orderNumber = nextOrderNumber++;
        this.orderStatus = orderStatus;
        this.items = items;
        this.timeCreated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderStatus='" + orderStatus + '\'' +
                ", items=" + items +
                ", timeCreated=" + timeCreated +
                '}';
    }

    /**
     * add all items to an order
     * @param item item to add
     */
    public void addItem(Item item) {
        if (item != null) items.add(item);
    }

    public class OrderTimeComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getTimeCreated().compareTo(o2.getTimeCreated());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(items, order.items) && Objects.equals(timeCreated, order.timeCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderStatus, items, timeCreated);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public static int getNextOrderNumber() {
        return nextOrderNumber;
    }

    public static void setNextOrderNumber(int nextOrderNumber) {
        Order.nextOrderNumber = nextOrderNumber;
    }
}
