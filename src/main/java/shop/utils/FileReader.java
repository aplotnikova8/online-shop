package shop.utils;

import shop.order.models.Order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static shop.utils.Constants.*;

public class FileReader {

    public static Stream<String> readFile() {
        try {
            return Files.lines(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    public static List<String> getLoyaltyCustomers() {
        return readFile().filter(string -> string.contains(PARTICIPANT_IN_LOYALTY))
                     .map(string -> string.split("\\|"))
                     .map(s -> s[COLUMN_WITH_NAME])
                     .distinct()
                     .collect(Collectors.toList());
    }

    public static Optional<Order> reconstructOrder() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream oi = new ObjectInputStream(fis)) {
            return Optional.ofNullable((Order) oi.readObject());
        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
