package shop;

import shop.administratorWork.AdministratorAccount;
import shop.converters.ConverterToOrders;
import shop.converters.fabrics.ConvertersFabric;
import shop.order.models.Order;

import java.util.List;

public class AdministratorReport {

    public static void main(String[] args) {
        ConverterToOrders converter = ConvertersFabric.createConverter();
        List<Order> ordersFromFile = converter.convertToOrders();

        for (Order order : ordersFromFile) {
            System.out.println(order.convertToString());
        }

        AdministratorAccount admin = new AdministratorAccount(ordersFromFile);
        System.out.println("-----");
        System.out.println(admin.getLoyaltyCustomers());
        System.out.println("-----");
        System.out.println(admin.getTotalPrice("4171130401"));
        System.out.println("-----");
        admin.displayCustomerStory("abgxyiamq uyynfq");
        System.out.println("-----");
        System.out.println(admin.checkIfGCwasUsedInPeriod("01/02/2021 00:00:00", "02/02/2021 00:00:00"));
        System.out.println("-----");
        System.out.println(admin.purchaseAmountByCash());
        System.out.println("-----");
        System.out.println(admin.getCustomersNames());
        System.out.println("-----");
        admin.displayNewCustomersWithLoyalty();
        System.out.println("-----");
    }

}
