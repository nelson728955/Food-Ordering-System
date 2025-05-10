package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver extends User {
    private int id;
    private List<Order> assignedOrders = new ArrayList<>();

    private static int nextId = 0;

    public Driver() {
        super();
        this.id = nextId++;
    }

    public Driver(String username, String email) {
        super(username, email);
        this.id = nextId++;
    }

    /**
     * lets the driver see all the available deliveries
     * @return list of available deliveries
     */
    public List<DeliveryOrder> viewAvailableDeliveries(List<DeliveryOrder> allOrders) {
        return allOrders.stream()
                .filter(order -> order.getAssignedDriver() == null && order.getOrderStatus() == Order.OrderStatus.PENDING)
                .toList();
    }

    /**
     * lets the driver accept an order
     * @param order the order to accept
     */
    public void acceptDelivery(DeliveryOrder order) {
        assignedOrders.add(order);
        order.setAssignedDriver(this.username);
        order.setOrderStatus(Order.OrderStatus.OUT_FOR_DELIVERY);
    }

    /**
     * updates the orders status after delivering the order
     * @param order the input order
     */
    public void updateStatus(Order order) {
        order.setOrderStatus(Order.OrderStatus.DELIVERED);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return id == driver.id && Objects.equals(assignedOrders, driver.assignedOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, assignedOrders);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", assignedOrders=" + assignedOrders +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }

    public void setAssignedOrders(List<Order> assignedOrders) {
        this.assignedOrders = assignedOrders;
    }
}
