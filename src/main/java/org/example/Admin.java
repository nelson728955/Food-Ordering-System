package org.example;

import java.util.List;
import java.util.Objects;

public class Admin extends User {
    int id;

    private static int nextId = 0;

    public Admin() {
        super();
        this.id = nextId++;
    }

    public Admin(String username, String email) {
        super(username, email);
        this.id = nextId++;
    }

    /**
     * gives access to view the report of all completed orders
     * @return The list of completed orders
     */
    public List<Order> viewReport() {
        //TODO
        return null;
    }

    /**
     * gives access to view the report of all open orders
     * @return The list of open orders
     */
    public List<Order> viewOpenOrders() {
        //TODO
        return null;
    }

    /**
     * processes the order that is next in the queue
     */
    public void processOrder() {
        //TODO
    }

    /**
     * cancels an order from the queue
     * @param order the order to be canceled
     * @return a boolean value whether if the cancelation was successful
     */
    public boolean cancelOrder(Order order) {
        //TODO
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return id == admin.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Admin.nextId = nextId;
    }
}
