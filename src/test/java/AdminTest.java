import org.example.Admin;
import org.example.DeliveryOrder;
import org.example.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {
    @Test
    void viewReportTest() {
        Admin admin = new Admin("admin1", "admin@example.com");
        DeliveryOrder deliveredOrder = new DeliveryOrder();
        DeliveryOrder pendingOrder = new DeliveryOrder();

        admin.processOrder(deliveredOrder);
        admin.processOrder(pendingOrder);
        deliveredOrder.setOrderStatus(Order.OrderStatus.DELIVERED);
        pendingOrder.setOrderStatus(Order.OrderStatus.PENDING);

        List<Order> expected = new ArrayList<>();
        expected.add(deliveredOrder);

        List<Order> actual = admin.viewReport();
        assertEquals(expected, actual);
    }

    @Test
    void viewOpenOrdersTest() {
        Admin admin = new Admin("admin2", "admin2@example.com");
        DeliveryOrder preparingOrder = new DeliveryOrder();
        preparingOrder.setOrderStatus(Order.OrderStatus.PREPARING);
        DeliveryOrder deliveredOrder = new DeliveryOrder();
        deliveredOrder.setOrderStatus(Order.OrderStatus.DELIVERED);

        admin.processOrder(preparingOrder);
        admin.processOrder(deliveredOrder);

        List<Order> expected = new ArrayList<>();
        expected.add(preparingOrder);
        expected.add(deliveredOrder);

        List<Order> actual = admin.viewOpenOrders();
        assertEquals(expected, actual);
    }

    @Test
    void processOrderTest() {
        Admin admin = new Admin("admin3", "admin3@example.com");
        DeliveryOrder order = new DeliveryOrder();

        admin.processOrder(order);

        assertEquals(Order.OrderStatus.PREPARING, order.getOrderStatus());
        List<Order> expected = new ArrayList<>();
        expected.add(order);
        assertEquals(expected, admin.viewOpenOrders());
    }


    @Test
    void cancelOrderTest() {
        Admin admin = new Admin("admin4", "admin4@example.com");
        DeliveryOrder order = new DeliveryOrder();

        admin.processOrder(order);
        boolean result = admin.cancelOrder(order);

        assertEquals(true, result);
        assertEquals(Order.OrderStatus.CANCELED, order.getOrderStatus());

        List<Order> expected = new ArrayList<>();
        assertEquals(expected, admin.viewOpenOrders());
    }
}

