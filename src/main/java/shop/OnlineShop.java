package shop;

import shop.converters.fabrics.ConvertersFabric;
import shop.converters.ConverterToOrders;
import shop.order.generators.OrderGenerator;
import shop.recording.RecordingToFile;
import shop.order.models.Order;
import shop.order.processing.OrderCollector;
import shop.order.processing.OrderFilter;

import java.util.List;

public class OnlineShop {

    public static void main(String[] args) {
        OrderGenerator orderGenerator = OrderGenerator.create();
        List<Order> generatedList = OrderCollector.createOrderList(orderGenerator);
        RecordingToFile.addOrdersListToFile(OrderFilter.createFilteringList(generatedList));

        ConverterToOrders converter = ConvertersFabric.createConverter();
        List<Order> listFromFile = converter.convertToOrders();

        for (Order order : listFromFile) {
            System.out.println(order.convertToString());
        }
    }
}
