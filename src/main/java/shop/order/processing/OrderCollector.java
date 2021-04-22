package shop.fileFormatting;

import shop.constantData.Constants;
import shop.order.models.Order;
import shop.order.generators.OrderGenerator;
import shop.utils.OrderComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static shop.constantData.Constants.MIN_ORDERS_LIST_SIZE;

public class OrderWriter {

    private static int getSize() {
        int number = 0;
        try {
            number = Integer.parseInt(PropertyFileReader.getProperties(Constants.NUMBER_OF_ORDERS));
            if (number == 0) {
                number = MIN_ORDERS_LIST_SIZE;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static List<String> createFilteringList(OrderGenerator orderGenerator) {
        List<String> list = new ArrayList<>();
        Comparator<String> orderComparator = new OrderComparator();

        for (int i = 0; i < getSize(); i++) {
            for (Order order : orderGenerator.generateOrder()) {
                list.add(order.convertToString());
            }
        }
}
