package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class PickupOrder extends Order {
    private LocalDateTime pickupTime;

    public PickupOrder() {
        this.pickupTime = LocalDateTime.now();
    }

    public PickupOrder(List<Item> items) {
        super(items);
        this.pickupTime = LocalDateTime.now();;
    }
}
