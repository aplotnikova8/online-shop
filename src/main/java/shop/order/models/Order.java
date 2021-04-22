package shop.orderModel;

import lombok.Builder;

import java.util.List;

@Builder
public class Order {

    protected String orderNumber;
    protected String customersName;
    protected Boolean loyalty;
    protected String date;
    protected String paymentType;
    protected List<Product> bucket;

    public String converToString() {
        return orderNumber +
                "|" + customersName +
                "|" + loyalty +
                "|" + date +
                "|" + productNumber +
                "|" + price +
                "|" + paymentType;
    }
}
