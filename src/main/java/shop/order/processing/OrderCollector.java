package shop.order.processing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import shop.order.generators.OrderGenerator;
import shop.order.models.Order;
import shop.utils.constants.GlobalConstants;
import shop.utils.PropertyFileReader;

import java.util.ArrayList;
import java.util.List;

import static shop.utils.constants.GlobalConstants.DEFAULT_ORDERS_LIST_SIZE;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCollector {

    private static int getSize() {
        int number = 0;
        try {
            number = Integer.parseInt(PropertyFileReader.getProperties(GlobalConstants.NUMBER_OF_ORDERS));
            if (number == 0) {
                number = DEFAULT_ORDERS_LIST_SIZE;
            }
        } catch (NumberFormatException e) {
            log.info("Can not parse constant " + GlobalConstants.NUMBER_OF_ORDERS + " to integer");
        }
        return number;
    }

    public static List<Order> createOrderList(OrderGenerator orderGenerator) {
        List<Order> list = new ArrayList<>();

        for (int i = 0; i < getSize(); i++) {
            int productNumber = (int) (Math.random() * GlobalConstants.MAX_BASKET_SIZE);
            list.add(orderGenerator.generateOrder(productNumber));
        }
        return list;
    }

}
