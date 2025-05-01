package org.example;

public interface Deliverable {
    public double calcDeliveryFee();
    public double calcTips(int percentage);
    public int calcEstimatedTime();
}
