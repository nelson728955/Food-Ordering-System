package org.example;

import java.util.List;
import java.util.Objects;

public class DeliveryOrder extends Order implements Deliverable {
    private Driver assignedDriver;
    private int distance;

    public DeliveryOrder() {
        super();
        this.assignedDriver = null;
        this.distance = 0;
    }

    public DeliveryOrder(List<Item> items, Driver assignedDriver, int distance) {
        super(items);
        this.assignedDriver = assignedDriver;
        this.distance = distance;
    }

    /**
     * calculates the delivery fee
     * @return the delivery fee
     */
    @Override
    public double calcDeliveryFee() {
        double baseFee = 3.50;
        return baseFee + distance * 0.5;
    }

    /**
     * calculates the tips
     * @param percentage the percentage to tip
     * @return the tip total
     */
    @Override
    public double calcTips(int percentage) {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        double tip = total * percentage / 100.0;
        return Math.round(tip * 100.0) / 100.0;
    }

    /**
     * calculates the estimated time taken
     * @return the estimated arrival time in minutes
     */
    @Override
    public int calcEstimatedTime() {
        int baseTime = 20;
        return baseTime + distance * 2;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "assignedDriver=" + assignedDriver +
                ", distance=" + distance +
                ", orderNumber=" + orderNumber +
                ", orderStatus='" + orderStatus + '\'' +
                ", items=" + items +
                ", timeCreated=" + timeCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryOrder that = (DeliveryOrder) o;
        return distance == that.distance && Objects.equals(assignedDriver, that.assignedDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assignedDriver, distance);
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
