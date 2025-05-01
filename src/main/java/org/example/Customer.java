package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private String address;
    private List<Order> activeOrders;

    public Customer() {
        super();
        this.address = "";
        this.activeOrders = new ArrayList<>();
    }

    public Customer(String username, String email, String address, List<Order> activeOrder) {
        super(username, email);
        this.address = address;
        this.activeOrders = activeOrder;
    }

    /**
     * lets the customer view the full menu of the restaurant along with the prices
     */
    public List<Item> viewMenu() {
        //TODO
    }

    /**
     * searches for an item that contains the keyword
     * @param keyword the keyword
     * @return a list of all items that contains the keyword
     */
    public List<Item> searchItem(String keyword) {
        return viewMenu().stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    /**
     * places an order with an item
     * @param item the input item
     */
    public void placeOrder(Item item) {
        Order order = new Order();
        order.addItem(item);
        activeOrders.add(order);
    }

    /**
     * places an order with a list of items
     * @param items the input list of items
     */
    public void placeOrder(List<Item> items) {
        Order order = new Order();
        for (Item item : items) {
            order.addItem(item);
        }
        activeOrders.add(order);
    }

    /**
     * Tracks the order of the customer
     * @return the status of the order
     */
    public String trackOrder(Order order) {
        return order.getOrderStatus();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
