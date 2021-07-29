package shop.utils.formats;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

@UtilityClass
public class CustomerNameFormatter {

    private static final int SECOND_NAME = 0;
    private static final int NAME = 1;
    private static final int PATRONYMIC = 2;


    public static String reformatCustomerName(String customerName) {
        String[] fullName = customerName.split("\\s");
        String name = fullName[NAME].split("")[0] + ".";
        if (fullName.length == 3) {
            String patronymic = fullName[PATRONYMIC].split("")[0] + ".";
            return String.join(" ", fullName[SECOND_NAME], name, patronymic);
        }
        return String.join(" ", fullName[SECOND_NAME], name);
    }

    public static String reformatCustomerName1(String customerName) {
        String[] nameParams = customerName.split("\\s");

        return Arrays.stream(nameParams)
                .skip(1)
                .map(name -> name.split("")[0] + ".")
                .collect(Collectors.joining(" ", nameParams[0], ""));
    }
}
