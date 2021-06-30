package shop.order.generators;

import lombok.RequiredArgsConstructor;
import shop.order.models.Order;

import static shop.order.generators.ProductsListGenerator.*;
import static shop.utils.constants.GlobalConstants.*;
import static shop.utils.formats.DateFormatter.*;
import static shop.utils.Generator.*;

@RequiredArgsConstructor(staticName = "create")
public class OrderGenerator {

    public Order generateOrder(int numberOfProducts) {
        return Order.builder().orderNumber(generateIntNumber(ORDER_NUMBER_SIZE))
                .customersName(generateString())
                .loyalty(generateBoolean())
                .date(getDate())
                .basket(generateProductList(numberOfProducts))
                .paymentType(generatePaymentType())
                .build();
    }

}
