package shop.order.processing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import shop.order.generators.OrderGenerator;
import shop.order.models.Order;
import shop.utils.Constants;
import shop.utils.PropertyFileReader;

import java.util.ArrayList;
import java.util.List;

import static shop.utils.Constants.MIN_ORDERS_LIST_SIZE;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCollector {

    private static int getSize() {
        int number = 0;
        try {
            number = Integer.parseInt(PropertyFileReader.getProperties(Constants.NUMBER_OF_ORDERS));
            if (number == 0) {
                number = MIN_ORDERS_LIST_SIZE;
            }
        } catch (NumberFormatException e) {
            log.info("Can not parse constant " + Constants.NUMBER_OF_ORDERS + " to integer");
        }
        return number;
    }

    public static List<Order> createOrderList(OrderGenerator orderGenerator) {
        List<Order> list = new ArrayList<>();

        for (int i = 0; i < getSize(); i++) {
            int productNumber = (int) (Math.random() * Constants.MAX_BUCKET_SIZE);
            list.add(orderGenerator.generateOrder(productNumber));
        }
        return list;
    }

}
