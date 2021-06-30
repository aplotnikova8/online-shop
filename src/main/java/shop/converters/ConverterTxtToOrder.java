package shop.converters;

import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.order.processing.OrderMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static shop.utils.constants.GlobalConstants.FILE_NAME;

@Log
public class ConverterTxtToOrder implements ConverterToOrders {

    @Override
    public List<Order> convertToOrders() {
        return OrderMapper.mapToOrdersList(readLinesFromFile());
    }

    private static Stream<String> readLinesFromFile() {
        try {
            return Files.lines(Paths.get(FILE_NAME));
        } catch (IOException e) {
            log.info("File with path " + FILE_NAME + " was not found");
        }
        return Stream.empty();
    }

/*    private static Map<String, List<String>> convertLinesToOrdersMap(int keysPostion) {
        try {
            return Files.lines(Paths.get(FILE_NAME))
                    .collect(Collectors.groupingBy(s -> s.split("\\|")[keysPostion],
                            TreeMap::new, Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_MAP;
    }*/

}


