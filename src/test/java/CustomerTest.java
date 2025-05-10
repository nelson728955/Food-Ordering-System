import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    void viewMenuTest() {
        OrderSystem.menu.clear();
        OrderSystem.menu.add(new Item("Burger", 5.99));
        OrderSystem.menu.add(new Item("Fries", 2.99));
        OrderSystem.menu.add(new Item("Pizza", 8.49));

        Customer customer = new Customer("Alice", "alice@example.com", "123 Main St");

        List<Item> expected = new ArrayList<>(OrderSystem.menu);
        List<Item> result = customer.viewMenu();

        assertEquals(expected, result);
    }

    @Test
    void searchItemTest1_exactMatch() {
        OrderSystem.menu.clear();
        OrderSystem.menu.add(new Item("Burger", 7.99));
        OrderSystem.menu.add(new Item("Fries", 2.99));

        Customer customer = new Customer("Alice", "alice@example.com", "123 Main St");

        List<Item> expected = new ArrayList<>(List.of(new Item("Fries", 2.99)));
        List<Item> result = customer.searchItem("Fries");

        assertEquals(expected, result);
    }

    @Test
    void searchItemTest2_caseInsensitive() {
        OrderSystem.menu.clear();
        OrderSystem.menu.add(new Item("Burger", 7.99));
        OrderSystem.menu.add(new Item("Fries", 2.99));

        Customer customer = new Customer("Alice", "alice@example.com", "123 Main St");

        List<Item> expected = new ArrayList<>(List.of(new Item("Fries", 2.99)));
        List<Item> result = customer.searchItem("fries");

        assertEquals(expected, result);
    }

    @Test
    void searchItemTest3_notFound() {
        OrderSystem.menu.clear();
        OrderSystem.menu.add(new Item("Burger", 7.99));
        Customer customer = new Customer("Bob", "bob@gmail.com", "456 Oak St");
        assertEquals(new ArrayList<>(), customer.searchItem("Salad"));
    }

    @Test
    void placeOrderTest1_pickup() {
        Item burger = new Item("Burger", 7.99);
        Customer customer = new Customer("Charlie", "charlie@gmail.com", "789 Pine St");
        customer.placeOrder(burger, false);
        assertEquals(List.of(burger), customer.getActiveOrder().getItems());
    }

    @Test
    void placeOrderTest2_delivery() {
        Item burger = new Item("Burger", 7.99);
        Customer customer = new Customer("Daisy", "daisy@gmail.com", "111 Elm St");
        customer.placeOrder(burger, true);
        assertEquals(List.of(burger), customer.getActiveOrder().getItems());
    }

    @Test
    void placeOrderTest3_nullItem() {
        Customer customer = new Customer("Eva", "eva@gmail.com", "222 Birch St");
        customer.placeOrder((Item) null, false);
        assertEquals(new ArrayList<>(), customer.getActiveOrder().getItems());
    }

    @Test
    void placeOrderListTest1_pickup() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("Fries", 3.99);
        List<Item> items = List.of(burger, fries);
        Customer customer = new Customer("Frank", "frank@gmail.com", "333 Cedar St");
        customer.placeOrder(items, false);
        assertEquals(items, customer.getActiveOrder().getItems());
    }

    @Test
    void placeOrderListTest2_delivery() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("Fries", 3.99);
        List<Item> items = List.of(burger, fries);
        Customer customer = new Customer("Gina", "gina@gmail.com", "444 Walnut St");
        customer.placeOrder(items, true);
        assertEquals(items, customer.getActiveOrder().getItems());
    }

    @Test
    void placeOrderListTest3_emptyList() {
        Customer customer = new Customer("Harry", "harry@gmail.com", "555 Maple St");
        customer.placeOrder(new ArrayList<>(), false);
        assertEquals(new ArrayList<>(), customer.getActiveOrder().getItems());
    }

    @Test
    void trackOrderTest() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("Fries", 3.99);
        List<Item> items = List.of(burger, fries);
        PickupOrder order = new PickupOrder(items);

        Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
        bobby.placeOrder(items, false);

        String expected = "PENDING";
        String result = bobby.trackOrder();

        assertEquals(expected, result);
    }

    @Test
    void trackOrderTest1_pending() {
        Item burger = new Item("Burger", 7.99);
        Item fries = new Item("Fries", 3.99);
        List<Item> items = List.of(burger, fries);
        PickupOrder order = new PickupOrder(items);

        Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
        bobby.placeOrder(items, false);

        String expected = "PENDING";
        String result = bobby.trackOrder();

        assertEquals(expected, result);
    }

    @Test
    void trackOrderTest2_delivered() {
            Item burger = new Item("Burger", 7.99);
            Item fries = new Item("Fries", 3.99);
            List<Item> items = List.of(burger, fries);
            PickupOrder order = new PickupOrder(items);

            Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
            bobby.placeOrder(items, false);

            String expected = "DELIVERED";
            bobby.getActiveOrder().setOrderStatus(Order.OrderStatus.DELIVERED);
            String result = bobby.trackOrder();

            assertEquals(expected, result);
        }

    @Test
    void trackOrderTest3_canceled() {
            Item burger = new Item("Burger", 7.99);
            Item fries = new Item("Fries", 3.99);
            List<Item> items = List.of(burger, fries);
            PickupOrder order = new PickupOrder(items);

            Customer bobby = new Customer("Bobby", "bobby123@gmail.com", "321 av. St-croix");
            bobby.placeOrder(items, false);

            String expected = "CANCELED";
            bobby.getActiveOrder().setOrderStatus(Order.OrderStatus.CANCELED);
            String result = bobby.trackOrder();

            assertEquals(expected, result);
        }
}


