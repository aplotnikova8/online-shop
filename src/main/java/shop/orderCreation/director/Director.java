package shop.orderCreation.director;

import shop.orderCreation.builders.Builder;
import shop.orderCreation.builders.OrderBuilder;
import shop.orderCreation.model.Order;

import java.util.List;

public class Director {

    private Director() {}

    public static Director createDirector() {
        return new Director();
    }

    public void constructOrder(Builder builder) {
        builder.setOrderNumber();
        builder.setCustomName();
        builder.checkLoyalty();
        builder.setDate();
        builder.setProductNumber();
        builder.setPrice();
        builder.choosePaymentType();
    }

    public static List<Order> generateOrder(Director director, OrderBuilder builder) {
        director.constructOrder(builder);
        return builder.getBucket((int) (Math.random() * 10));
    }

}
