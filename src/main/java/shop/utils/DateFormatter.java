package shop.utils;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@UtilityClass
public class DateFormatter {

    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Generator.generateDate(calendar);
        return formatter.format(calendar.getTime());
    }

}
