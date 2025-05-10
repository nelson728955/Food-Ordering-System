package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
     * @return the menu as a list of items
     */
    public List<Item> viewMenu() {
        List<Item> menu = new LinkedList<>();
        File file = new File("src/main/resources/menu.csv");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                Item item = new Item(name, price);
                menu.add(item);

            }
        } catch (FileNotFoundException e) {
        }

        return menu;
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
    public String trackOrder() {
        if (activeOrder == null) return "No active order";
        return activeOrder.getOrderStatus().toString();
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
