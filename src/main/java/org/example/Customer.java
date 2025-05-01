package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private String address;
    private Order activeOrder;

    public Customer() {
        super();
        this.address = "";
        this.activeOrder = null;
    }

    public Customer(String username, String email, String address) {
        super(username, email);
        this.address = address;
        this.activeOrder = null;
    }

    /**
     * lets the customer view the full menu of the restaurant along with the prices
     */
    public List<Item> viewMenu() {
        //TODO
        return null;
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
     * @param delivery a boolean value whether if the customer wants a delivery order or not
     */
    public void placeOrder(Item item, boolean delivery) {
        if (delivery) {
           activeOrder = new DeliveryOrder();
           activeOrder.addItem(item);
        } else {
            activeOrder = new PickupOrder();
            activeOrder.addItem(item);
        }
    }

    /**
     * places an order with a list of items
     * @param items the input list of items
     * @param delivery a boolean value whether if the customer wants a delivery order or not
     */
    public void placeOrder(List<Item> items, boolean delivery) {
        if (delivery) {
            activeOrder = new DeliveryOrder();
            for (Item item : items) {
                activeOrder.addItem(item);
            }
        } else {
            activeOrder = new PickupOrder();
            for (Item item : items) {
                activeOrder.addItem(item);
            }
        }
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

    public Order getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(Order activeOrder) {
        this.activeOrder = activeOrder;
    }
}
