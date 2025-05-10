import org.example.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {

    @Test
    void viewAvailableDeliveriesTest1_emptyList() {
        Driver driver = new Driver("Tom", "tom@driver.com");
        List<DeliveryOrder> deliveryOrders = new ArrayList<>();

        List<DeliveryOrder> result = driver.viewAvailableDeliveries(deliveryOrders);

        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void viewAvailableDeliveriesTest2_singleAvailableOrder() {
        Driver driver = new Driver("Sam", "sam@driver.com");
        DeliveryOrder order1 = new DeliveryOrder(List.of(new Item("Pizza", 12.99)), null, 4);
        order1.setOrderStatus(Order.OrderStatus.PENDING);

        List<DeliveryOrder> deliveryOrders = List.of(order1);

        List<DeliveryOrder> expected = List.of(order1);
        List<DeliveryOrder> result = driver.viewAvailableDeliveries(deliveryOrders);

        assertEquals(expected, result);
    }

    @Test
    void viewAvailableDeliveriesTest3_mixedStatusOrders() {
        Driver driver = new Driver("Lee", "lee@driver.com");

        DeliveryOrder order1 = new DeliveryOrder(List.of(new Item("Burger", 7.99)), null, 5);
        order1.setOrderStatus(Order.OrderStatus.PENDING);

        DeliveryOrder order2 = new DeliveryOrder(List.of(new Item("Fries", 2.99)), null, 2);
        order2.setOrderStatus(Order.OrderStatus.OUT_FOR_DELIVERY);

        DeliveryOrder order3 = new DeliveryOrder(List.of(new Item("Taco", 3.99)), null, 3);
        order3.setOrderStatus(Order.OrderStatus.DELIVERED);

        List<DeliveryOrder> deliveryOrders = List.of(order1, order2, order3);

        List<DeliveryOrder> expected = List.of(order1);  // assuming only PENDING orders are available
        List<DeliveryOrder> result = driver.viewAvailableDeliveries(deliveryOrders);

        assertEquals(expected, result);
    }

    @Test
    void acceptDeliveriesTest1_assignOneOrder() {
        OrderSystem.pendingOrders.clear();
        DeliveryOrder order = new DeliveryOrder(new ArrayList<>(), null, 3);
        OrderSystem.pendingOrders.add(order);

        Driver driver = new Driver("Alex", "alex@gmail.com");
        driver.acceptDelivery(order);

        assertEquals(driver.getUsername(), order.getAssignedDriver());
    }

    @Test
    void acceptDeliveriesTest2_assignMultipleOrders() {
        OrderSystem.pendingOrders.clear();
        DeliveryOrder order1 = new DeliveryOrder(new ArrayList<>(), null, 4);
        DeliveryOrder order2 = new DeliveryOrder(new ArrayList<>(), null, 6);
        OrderSystem.pendingOrders.add(order1);
        OrderSystem.pendingOrders.add(order2);

        Driver driver = new Driver("Bob", "bob@gmail.com");
        driver.acceptDelivery(order1);
        driver.acceptDelivery(order2);

        assertEquals(driver.getUsername(), order1.getAssignedDriver());
        assertEquals(driver.getUsername(), order2.getAssignedDriver());
    }

    @Test
    void acceptDeliveriesTest3_orderAlreadyAssigned() {
        DeliveryOrder order = new DeliveryOrder(new ArrayList<>(), "OtherDriver", 3);

        Driver driver = new Driver("Chris", "chris@gmail.com");
        driver.acceptDelivery(order); // Should not override

        assertEquals("Chris", order.getAssignedDriver());
    }

    @Test
    void updateStatusTest_toDelivered() {
        DeliveryOrder order = new DeliveryOrder(new ArrayList<>(), null, 2);
        order.setOrderStatus(Order.OrderStatus.PREPARING);

        Driver driver = new Driver("Eli", "eli@gmail.com");
        driver.acceptDelivery(order);
        driver.updateStatus(order);

        assertEquals(Order.OrderStatus.DELIVERED, order.getOrderStatus());
    }
}

