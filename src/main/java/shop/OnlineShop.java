package shop;

import shop.order.generators.OrderGenerator;
import shop.fileFormatter.FilePreparation;
import shop.order.models.Order;
import shop.order.processing.OrderCollector;
import shop.order.processing.OrderFilter;

import java.util.List;

public class OnlineShop {

    public static void main(String[] args) {
        OrderGenerator orderGenerator = OrderGenerator.create();
        List<Order> list = OrderCollector.createOrderList(orderGenerator);
        FilePreparation.addOrdersListToFile(OrderFilter.createFilteringList(list));
    }

}
