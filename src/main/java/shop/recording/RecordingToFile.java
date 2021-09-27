package shop.recording;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.utils.formats.FileFormatter;
import shop.utils.formats.JsonFormatter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static shop.utils.constants.GlobalConstants.*;

@Log
@UtilityClass
public class RecordingToFile {

    public static void addOrdersListToFile(List<Order> orderList) {
        try (BufferedWriter file = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            FileFormatter type = FileFormatSpecifier.determineOrdersFormat();
            for (Order o : orderList) {
                switch (type) {
                    case JSON:
                        file.write(JsonFormatter.formatOrderToJson(o) + "\n");
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
