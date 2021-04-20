package shop.orderCreation.builders;

import shop.utils.Generator;
import shop.orderCreation.model.Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderBuilder implements Builder {

    private String orderNumber;
    private String customersName;
    private Boolean loyalty;
    private String date;
    private String productNumber;
    private String price;
    private String paymentType;

    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private OrderBuilder() {}

    public static OrderBuilder createOrderBuilder() {
        return new OrderBuilder();
    }

    @Override
    public void setOrderNumber() {
        this.orderNumber = Generator.generateIntNumber(10);
    }

    @Override
    public void setCustomName() {
        this.customersName = Generator.generateString();
    }

    @Override
    public void checkLoyalty() {
        this.loyalty = Generator.generateBoolean();
    }

    @Override
    public void setDate() {
        Calendar calendar = Calendar.getInstance();
        Generator.generateDate(calendar);
        this.date = formatter.format(calendar.getTime());
    }

    @Override
    public void setProductNumber() {
        this.productNumber = Generator.generateIntNumber(8);
    }

    @Override
    public void setPrice() {
        this.price = Generator.generateDoubleNumber();
    }

    @Override
    public void choosePaymentType() {
        this.paymentType = Generator.choosePaymentType();
    }

    public List<Order> getBucket(int bucketSize) {
        return IntStream.rangeClosed(0, bucketSize)
                .mapToObj(i -> new Order(orderNumber, customersName, loyalty, date, Generator.generateIntNumber(8), Generator.generateDoubleNumber(), paymentType))
                .collect(Collectors.toList());
    }
}
