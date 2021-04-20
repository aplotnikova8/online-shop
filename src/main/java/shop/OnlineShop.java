package shop;

import shop.orderCreation.builders.OrderBuilder;
import shop.orderCreation.director.Director;
import shop.utils.FileCreator;

public class OnlineShop {

    public static void main(String[] args) {
        OrderBuilder builder = OrderBuilder.createOrderBuilder();
        Director director = Director.createDirector();
        FileCreator.addOrdersListToFile(director,builder);
    }

}
