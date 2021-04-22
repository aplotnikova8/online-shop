package shop.orderModel;

import static shop.orderModel.ProductsListGenerator.*;
import static shop.constantData.Constants.*;
import static shop.utils.DateFormatter.*;
import static shop.utils.Generator.*;

public class OrderGenerator {

    private OrderGenerator() {}

    public static OrderGenerator createOrderGenerator() {
        return new OrderGenerator();
    }

    public Order generateOrder(int numberOfProducts) {
        return Order.builder().orderNumber(generateIntNumber(ORDER_NUMBER_SIZE))
                .customersName(generateString())
                .loyalty(generateBoolean())
                .date(getDate())
                .bucket(generateProductList(numberOfProducts))
                .paymentType(generatePaymentType())
                .build();
    }

}
