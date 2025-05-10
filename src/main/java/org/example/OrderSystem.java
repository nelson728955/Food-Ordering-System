package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OrderSystem {
    public static Queue<Order> pendingOrders = new LinkedList<>();
    public static List<Order> completedOrders = new ArrayList<>();
    public static List<Item> menu = new ArrayList<>();

    public static void addOrder(Order order) {
        pendingOrders.add(order);
    }

    /**
     * reads from a file and adds it to the menu
     * @param path the input file
     */
    public static void initOrders(String path) {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                menu.add(new Item(parts[0], Double.parseDouble(parts[1])));
            }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Write completed orders to a file
     * @param path the input path
     */
    public static void writeOrdersToFile(String path) {
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file)) {
            for (Order order : completedOrders) {
                fw.write(order.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
