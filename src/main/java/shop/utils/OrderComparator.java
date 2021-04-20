package shop.utils;

import java.util.Comparator;

public class OrderComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) throws NumberFormatException{
        long a = Long.parseLong(o1.split("\\|")[0]);
        long b = Long.parseLong(o2.split("\\|")[0]);
        if (a-b > 0) return 1;
        else
            if (a-b < 0) return -1;
            else return 0;
    }
}
