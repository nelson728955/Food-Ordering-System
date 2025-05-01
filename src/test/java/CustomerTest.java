import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    void viewMenuTest() {
        //TODO
    }

    @Test
    void searchItemTest() {
       //TODO
    }

    @Test
    void placeOrderTest1() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("fries", 3.99);
        Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
        bobby.placeOrder(burger, false);

        PickupOrder expected = new PickupOrder(new ArrayList<>(List.of(burger)));
        Order result = bobby.getActiveOrder();

        Assertions.assertEquals(expected, result);
        //Just the Order Number not the same
    }

    @Test
    void placeOrderTest2() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("fries", 3.99);
        Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
        List<Item> items = new ArrayList<>(List.of(burger, fries));
        bobby.placeOrder(items, false);

        PickupOrder expected = new PickupOrder(new ArrayList<>(List.of(burger, fries)));
        Order result = bobby.getActiveOrder();

        Assertions.assertEquals(expected, result);
        //Just the Order Number not the same
    }

    @Test
    void trackOrderTest() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("fries", 3.99);
        Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
        List<Item> items = new ArrayList<>(List.of(burger, fries));
        PickupOrder order = new PickupOrder(items);

        String expected = "open";
        String result = bobby.trackOrder(order);

        Assertions.assertEquals(expected, result);
    }

}
