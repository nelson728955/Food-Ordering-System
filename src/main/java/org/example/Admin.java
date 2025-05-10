package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {
    private List<Order> receivedOrders = new ArrayList<>();

    public Admin() {
        super();
    }

    public Admin(String username, String email) {
        super(username, email);
    }

    /**
     * gives access to view the report of all completed orders
     * @return The list of completed orders
     */
    public List<Order> viewReport() {
        return receivedOrders.stream()
                .filter(order -> order.getOrderStatus() == Order.OrderStatus.DELIVERED)
                .toList();
    }

    /**
     * gives access to view the report of all open orders
     * @return The list of open orders
     */
    public List<Order> viewOpenOrders() {
        return receivedOrders.stream()
                .filter(order -> order.getOrderStatus() != Order.OrderStatus.DELIVERED)
                .toList();
    }

    /**
     * processes an order and updates the status of the order
     * @param order the order to process
     */
    public void processOrder(Order order) {
        order.setOrderStatus(Order.OrderStatus.PREPARING);
        receivedOrders.add(order);
    }

    /**
     * cancels an order from the queue
     * @param order the order to be canceled
     * @return a boolean value whether if the cancelation was successful
     */
    public boolean cancelOrder(Order order) {
        if (receivedOrders.contains(order)) {
            receivedOrders.remove(order);
            order.setOrderStatus(Order.OrderStatus.CANCELED);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "receivedOrders=" + receivedOrders +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(receivedOrders, admin.receivedOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), receivedOrders);
    }

    public List<Order> getReceivedOrders() {
        return receivedOrders;
    }

    public void setReceivedOrders(List<Order> receivedOrders) {
        this.receivedOrders = receivedOrders;
    }
}
