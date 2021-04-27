package shop.filePreparation;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.utils.FormatSpecifier;
import shop.utils.FileFormat;
import shop.utils.formatter.JsonFormatter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static shop.utils.Constants.*;

@Log
@UtilityClass
public class RecordingToFile {

    public static void addOrdersListToFile(List<Order> orderList) {
        try (BufferedWriter file = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            FileFormat type = FormatSpecifier.determineOrdersFormat();
            for (Order o : orderList) {
                switch (type) {
                    case JSON:
                        file.write(JsonFormatter.formatOrderToJson(o));
                        break;
                    case TXT:
                        file.write(o.convertToString());
                        break;
                }
            }
        } catch (IOException e) {
            log.info("File " + FILE_NAME + "does not exist");
        }
    }

}
