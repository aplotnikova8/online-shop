package shop.utils.formats;

import lombok.experimental.UtilityClass;
import shop.utils.Generator;

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
