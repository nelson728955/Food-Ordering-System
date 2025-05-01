package org.example;

import java.util.List;

public class Driver extends User {
    int id;

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
    public List<DeliveryOrder> viewAvailableDeliveries() {
        //TODO
        return null;
    }

    /**
     * lets the driver accept an order
     * @param order the order to accept
     * @return a boolean value whether it was accepted successfully
     */
    public boolean acceptDelivery(Order order) {
        //TODO
        return false;
    }

    /**
     * updates the orders status
     * @param order the input order
     * @param newStatus the new status
     */
    public void updateStatus(Order order, String newStatus) {
        //TODO
    }


}
