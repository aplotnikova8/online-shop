package shop.fileFormatter;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.order.models.Order;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static shop.utils.Constants.*;

@Log
@UtilityClass
public class FilePreparation {

    public static void addOrdersListToFile(List<Order> orderList) {
        try (BufferedWriter file = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            for (Order o : orderList) {
                file.write(o.convertToString());
            }
        } catch (IOException e) {
            log.info("File " + FILE_NAME + "does not exist");
        }
    }

}
