package shop.order.processing;

import shop.order.models.Order;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) throws NumberFormatException {
        long a = Long.parseLong(o1.getOrderNumber());
        long b = Long.parseLong(o2.getOrderNumber());
        if (a - b > 0) return 1;
        else if (a - b < 0) return -1;
        else return 0;
    }

}
