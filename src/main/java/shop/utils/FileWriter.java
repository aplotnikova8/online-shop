package shop.utils;

import shop.order.models.Order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

    public static void writeObjectToFile(Order order) {
        try (FileOutputStream fo = new FileOutputStream(Constants.FILE_NAME);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(order.convertToString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
