package shop.fileFormatting;

import shop.utils.OrderComparator;

import java.util.Comparator;
import java.util.List;

public class OrderFilter {

    private static List<String> createFilteringList(List<String> list) {
        Comparator<String> orderComparator = new OrderComparator();
        try {
            list.sort(orderComparator);
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
