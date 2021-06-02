package shop;

import shop.order.generators.OrderGenerator;
import shop.filePreparation.RecordingToFile;
import shop.order.models.Order;
import shop.order.processing.OrderCollector;
import shop.order.processing.OrderFilter;
import shop.utils.FileReader;
import shop.utils.FileWriter;

import java.util.List;

public class OnlineShop {

    public static void main(String[] args) {
        OrderGenerator orderGenerator = OrderGenerator.create();
        List<Order> list = OrderCollector.createOrderList(orderGenerator);
        RecordingToFile.addOrdersListToFile(OrderFilter.createFilteringList(list));
        System.out.println(FileReader.getLoyaltyCustomers());


       /* list.forEach(FileWriter::writeObjectToFile);
        Order order = FileReader.reconstructOrder().get();
        System.out.println(order.convertToString());*/





    }

}
