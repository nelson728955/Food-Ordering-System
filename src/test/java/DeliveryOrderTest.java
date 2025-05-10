import org.example.DeliveryOrder;
import org.example.Driver;
import org.example.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderTest {
    @Test
    void calcDeliveryFeeTest1() {
        Item burger = new Item("Burger", 7.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger));
        DeliveryOrder order = new DeliveryOrder(items,"bobby", 7);
        double expected = 7.00;
        double result = order.calcDeliveryFee();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calcDeliveryFeeTest2() {
        Item burger = new Item("Burger", 7.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger));
        DeliveryOrder order = new DeliveryOrder(items, "bobby", 0);
        double expected = 3.5;
        double result = order.calcDeliveryFee();

        Assertions.assertEquals(expected, result);
    }


    @Test
    void calcTipsTest1() {
        Item burger = new Item("Burger", 7.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger));
        DeliveryOrder order = new DeliveryOrder(items, "bobby", 7);
        double expected = 1.20;
        double result = order.calcTips(15);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calcTipsTest2() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("fries", 3.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger, fries));
        DeliveryOrder order = new DeliveryOrder(items, "bobby", 7);
        double expected = 1.80;
        double result = order.calcTips(15);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calcEstimatedTimeTest1() {
        Item burger = new Item("Burger", 7.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger));
        DeliveryOrder order = new DeliveryOrder(items, "bobby", 7);
        double expected = 34;
        double result = order.calcEstimatedTime();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calcEstimatedTimeTest2() {
        Item burger = new Item("Burger", 7.99);
        Driver bobby = new Driver("Bobby", "bobby123@gmail.com");
        List<Item> items = new ArrayList<>(List.of(burger));
        DeliveryOrder order = new DeliveryOrder(items, "bobby", 0);
        double expected = 20;
        double result = order.calcEstimatedTime();

        Assertions.assertEquals(expected, result);
    }
}
