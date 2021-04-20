package shop.utils;

import shop.orderCreation.builders.OrderBuilder;
import shop.data.PropertyFile;
import shop.orderCreation.director.Director;
import shop.orderCreation.model.Order;

import java.io.*;
import java.util.*;

public class FileCreator {

    private static BufferedWriter prepareNewFile() throws IOException {
        return new BufferedWriter(new java.io.FileWriter("orders.txt", false));
    }

    public static void addOrdersListToFile(Director director, OrderBuilder builder) {
        try (BufferedWriter ordersList = FileCreator.prepareNewFile();) {
            List<String> filteringList = createFilteringList(director,builder);
            for (String s : filteringList) {
                ordersList.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int setSize() {
        int number = 0;
        try {
            number = Integer.parseInt(PropertyFile.getProperties("size"));
            if (number == 0) {
                number = 10;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static List<String> createFilteringList(Director director, OrderBuilder builder) {
        List<String> list = new ArrayList<>();
        Comparator<String> orderComparator = new OrderComparator();

        for (int i = 0; i < setSize(); i++) {
            for (Order order : Director.generateOrder(director, builder)) {
                list.add(order.toString());
            }
        }
            try {
                list.sort(orderComparator);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        return list;
    }

}
