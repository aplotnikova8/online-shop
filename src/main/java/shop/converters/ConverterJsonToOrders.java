package shop.converters;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import lombok.extern.java.Log;
import shop.order.models.Order;
import shop.utils.constants.GlobalConstants;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log
public class ConverterJsonToOrders implements ConverterToOrders {

    @Override
    public List<Order> convertToOrders() {
        List<Order> orders = new ArrayList<>();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        try (JsonReader reader = new JsonReader(new FileReader(GlobalConstants.FILE_NAME));) {
            reader.setLenient(true);
            while (reader.hasNext() && !reader.peek().equals(JsonToken.END_DOCUMENT)) {
                orders.add(gson.fromJson(reader, Order.class));
            }
        } catch (IOException e) {
            log.info("There is no file with name " + GlobalConstants.FILE_NAME);
        } catch (JsonSyntaxException e) {
            log.info("Can not parse json to order format");
        }

        if (orders.isEmpty()) {
            return Collections.emptyList();
        } else {
            return orders;
        }
    }

}
