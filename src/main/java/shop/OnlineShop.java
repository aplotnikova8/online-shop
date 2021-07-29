package shop;

import shop.order.generators.OrderGenerator;
import shop.order.models.Order;
import shop.order.processing.OrderCollector;
import shop.order.processing.OrderFilter;
import shop.recording.RecordingToFile;

import java.util.List;

public class OnlineShop {

    public static void main(String[] args) {
        OrderGenerator orderGenerator = OrderGenerator.create();
        List<Order> generatedList = OrderCollector.createOrderList(orderGenerator);
        RecordingToFile.addOrdersListToFile(OrderFilter.createFilteringList(generatedList));
    }

}
