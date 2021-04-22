package shop.order.processing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import shop.order.models.Order;

import java.util.Comparator;
import java.util.List;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderFilter {

    public static List<Order> createFilteringList(List<Order> list) {
        Comparator<Order> orderComparator = new OrderComparator();
        try {
            list.sort(orderComparator);
        } catch (NumberFormatException e) {
            log.info("Incorrect order number format");
        }
        return list;
    }

}
