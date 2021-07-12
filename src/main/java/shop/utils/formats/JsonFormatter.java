package shop.utils.formats;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;
import shop.order.models.Order;

@UtilityClass
public class JsonFormatter {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String formatOrderToJson(Order order) {
        return GSON.toJson(order);
    }
}
