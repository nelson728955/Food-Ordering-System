package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PickupOrder extends Order {
    private LocalDateTime pickupTime;

    public PickupOrder() {
        this.pickupTime = LocalDateTime.now();
    }

    public PickupOrder(List<Item> items) {
        super(items);
        this.pickupTime = LocalDateTime.now();;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PickupOrder order = (PickupOrder) o;
        return Objects.equals(pickupTime, order.pickupTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pickupTime);
    }

    @Override
    public String toString() {
        return "PickupOrder{" +
                "pickupTime=" + pickupTime +
                ", orderNumber=" + orderNumber +
                ", orderStatus=" + orderStatus +
                ", items=" + items +
                ", timeCreated=" + timeCreated +
                '}';
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }
}
