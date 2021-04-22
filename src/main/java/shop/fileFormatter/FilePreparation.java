package shop.fileFormatter;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.order.models.Order;

import java.io.*;
import java.util.*;

import static shop.utils.Constants.*;

@Log
@UtilityClass
public class FilePreparation {

    private static BufferedWriter prepareNewFile() throws IOException {
        return new BufferedWriter(new FileWriter(FILE_NAME, false));
    }

    public static void addOrdersListToFile(List<Order> orderList) {
        try (BufferedWriter file = FilePreparation.prepareNewFile()) {
            for (Order o : orderList) {
                file.write(o.convertToString());
            }
        } catch (IOException e) {
            log.info("File " + FILE_NAME + "does not exist");
        }
    }

}
