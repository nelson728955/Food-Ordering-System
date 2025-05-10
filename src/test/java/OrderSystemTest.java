import org.example.Item;
import org.example.OrderSystem;
import org.example.PickupOrder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderSystemTest {

    @Test
    void initOrdersTest_multipleItems() throws Exception {
        OrderSystem.initOrders("src/main/resources/menu.csv");

        assertEquals(3, OrderSystem.menu.size());
        assertEquals("Fries", OrderSystem.menu.get(1).getName());

    }

    @Test
    void writeOrdersToFile_singleOrder() throws Exception {
        String path = "src/main/resources/completedOrders.csv";

        OrderSystem.completedOrders.clear();
        OrderSystem.completedOrders.add(new PickupOrder(List.of(new Item("Burger", 6.50))));

        OrderSystem.writeOrdersToFile(path);

        String content = Files.readString(new File(path).toPath());
        assertEquals(true, content.contains("Burger"));

        new File(path).delete();
    }
}
