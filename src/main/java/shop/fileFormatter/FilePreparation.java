package shop.fileFormatting;

import lombok.experimental.UtilityClass;
import shop.order.models.Order;

import java.io.*;
import java.util.*;

import static shop.utils.Constants.*;

@UtilityClass
public class FilePreparation {

    private static BufferedWriter prepareNewFile() throws IOException {
        return new BufferedWriter(new java.io.FileWriter(FILE_NAME, false));
    }

    public static void addOrdersListToFile(List<Order> orderList) {
        try (BufferedWriter file = FilePreparation.prepareNewFile()) {
            for (Order o : orderList) {
                file.write(o.convertToString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
