package shop.utils.formats;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import shop.utils.Generator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.regex.Pattern;

@UtilityClass
@Log
public class DateFormatter {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Generator.generateDate(calendar);
        return formatter.format(calendar.getTime());
    }

    public static LocalDate readDate(String date) {
        try {
            return LocalDate.parse(date, dateFormat);
        } catch (DateTimeParseException exception) {
            log.info("Can not read date format " + date + "! Please try mm/dd/yyyy. By default today is used");
            return LocalDate.parse(getDate(), dateFormat);
        }
    }

}
