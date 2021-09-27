package shop.order.processing;

import shop.order.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderMapper {

    private static final int ORDER_NUMBER_POSITION = 0;
    private static final int CUSTOMERS_NAME_POSITION = 1;
    private static final int LOYALTY_POSITION = 2;
    private static final int DATE_POSITION = 3;
    private static final int PAYMENT_TYPE_POSITION = 6;
    private static final int PRODUCT_NUMBER_POSITION = 4;
    private static final int PRODUCT_PRICE_POSITION = 5;

    public static List<Order> mapToOrdersList(Stream<String> linesFromFile) {
        List<Order> orderList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : convertLinesToOrdersMap(linesFromFile).entrySet()) {
            orderList.add(constructOrder(entry.getKey(), entry.getValue()));
        }
        return orderList;
    }

    private static Map<String, List<String>> convertLinesToOrdersMap(Stream<String> lines) {
        return lines
                .collect(Collectors.groupingBy(s -> s.split("\\|")[ORDER_NUMBER_POSITION],
                        TreeMap::new, Collectors.toList()));
    }

    private static Order constructOrder(String key, List<String> value) {
        Order order = Order.builder().orderNumber(key).build();
        for (String s : value) {
            String[] ordersPositions = s.split("\\|");
            order.setCustomersName(ordersPositions[CUSTOMERS_NAME_POSITION]);
            order.setLoyalty(Boolean.parseBoolean(ordersPositions[LOYALTY_POSITION]));
            order.setDate(ordersPositions[DATE_POSITION]);
            order.setPaymentType(ordersPositions[PAYMENT_TYPE_POSITION]);
            order.addInBasket(ordersPositions[PRODUCT_NUMBER_POSITION], ordersPositions[PRODUCT_PRICE_POSITION]);
        }
        return order;
    }

}
