package shop.administratorWork;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.order.models.Product;
import shop.utils.constants.PaymentType;
import shop.utils.formats.CustomerNameFormatter;
import shop.utils.formats.DateFormatter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Log
@AllArgsConstructor
public class AdministratorAccount {

    private List<Order> orderBase;
    private final double LOYALTY_THRESHOLD = 200.00;

    public List<String> getLoyaltyCustomers() {
        return orderBase.stream()
                .filter(Order::isLoyalty)
                .map(Order::getCustomersName)
                .collect(toList());
    }

    public Order getOrder(String requiredOrderNumber) {
        Optional<Order> searchOrder = orderBase.stream()
                .filter(order -> order.getOrderNumber().equals(requiredOrderNumber))
                .findFirst();
        return searchOrder.orElseThrow(() -> new IllegalArgumentException("Order with number " + requiredOrderNumber
                + " does not exist"));
    }

    public double getTotalPrice(String requiredOrderNumber) {
        return getOrder(requiredOrderNumber).getBasket().stream()
                .mapToDouble(product -> Double.parseDouble(product.getPrice()))
                .sum();

    }

    private Map<String, List<Product>> getCustomerStory(String name) {
        return orderBase.stream()
                .filter(order -> order.getCustomersName().equals(name))
                .collect(Collectors.groupingBy(Order::getOrderNumber, Collectors.flatMapping(order -> order
                        .getBasket().stream(), toList())));
    }

    public void displayCustomerStory(String name) {
        getCustomerStory(name)
                .forEach((orderId, products) -> System.out.println(("orderId: " + orderId + " SKUs: " + products.stream()
                        .map(Product::getProductNumber)
                        .collect(Collectors.joining(" ")))));
    }

    public boolean checkIfGCwasUsedInPeriod(String dateBegin, String dateEnd) {
        LocalDate periodBegins = DateFormatter.readDate(dateBegin);
        LocalDate periodEnds = DateFormatter.readDate(dateEnd);
        return orderBase.stream()
                .filter(order -> order.getPaymentType().contains(PaymentType.GC.toString()))
                .filter(order -> periodBegins.isBefore(DateFormatter.readDate(order.getDate())))
                .anyMatch(order -> periodEnds.isAfter(DateFormatter.readDate(order.getDate())));
    }

    public long purchaseAmountByCash() {
        return orderBase.stream()
                .filter(order -> order.getPaymentType().contains(PaymentType.CASH.toString()))
                .count();
    }

    public List<String> getCustomersNames() {
        return orderBase.stream()
                .map(order -> CustomerNameFormatter.reformatCustomerName(order.getCustomersName()))
                .collect(Collectors.toList());
    }

    private void changeLoyaltyStatus() throws NullPointerException {
        List<Optional<Order>> optionalOrders = new ArrayList<>();
        orderBase.stream()
                .filter(order -> Double.compare(getTotalPrice((order.getOrderNumber())), LOYALTY_THRESHOLD) == 1)
                .filter(order -> !order.isLoyalty())
                .peek(order -> System.out.println(order.getCustomersName()))
                .peek(order -> optionalOrders.add(Optional.of(order)))
                .forEach(order -> order.setLoyalty(true));

        if (optionalOrders.isEmpty()) {
            throw new NullPointerException();
        }
    }

    public void displayNewCustomersWithLoyalty() {
        try {
            changeLoyaltyStatus();
        } catch (NullPointerException exception) {
            log.info("There are no new customers who get loyalty status");
        }
    }

}
