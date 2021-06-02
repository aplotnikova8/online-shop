package shop.order.models;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
public class Order implements Serializable {

    protected String orderNumber;
    protected String customersName;
    protected Boolean loyalty;
    protected String date;
    protected String paymentType;
    protected List<Product> bucket;

    public String convertToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : bucket) {
            stringBuilder.append(orderNumber +
                    "|" + customersName +
                    "|" + loyalty +
                    "|" + date +
                    "|" + product.productNumber +
                    "|" + product.price +
                    "|" + paymentType + "\n");
        }
        return stringBuilder.toString();
    }

}
