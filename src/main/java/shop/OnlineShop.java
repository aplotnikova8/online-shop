package shop;

import shop.order.generators.OrderGenerator;
import shop.filePreparation.RecordingToFile;
import shop.order.models.Order;
import shop.order.processing.OrderCollector;
import shop.order.processing.OrderFilter;

import java.util.List;

public class OnlineShop {

    public static void main(String[] args) {
        OrderGenerator orderGenerator = OrderGenerator.create();
        List<Order> list = OrderCollector.createOrderList(orderGenerator);
        RecordingToFile.addOrdersListToFile(OrderFilter.createFilteringList(list));
    }

}
