package shop.filePreparation;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.utils.FormatSpecifier;
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
            boolean jsonType = FormatSpecifier.determineOrdersFormat();
            for (Order o : orderList) {
                if (jsonType) {
                    file.write(JsonFormatter.formatOrderToJson(o));
                }
                else {
                    file.write(o.convertToString());
                }
            }
        }
        catch (IllegalArgumentException e) {
            log.info("Can not correlate the parameter 'type' from the application.properties " +
                    "with file format (json/txt)");
        }
        catch (IOException e) {
            log.info("File " + FILE_NAME + "does not exist");
        }
    }

}
