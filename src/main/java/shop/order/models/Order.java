package shop.order.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Order {

    protected String orderNumber;
    protected String customersName;
    protected Boolean loyalty;
    protected String date;
    protected String paymentType;
    protected List<Product> basket;

    public String convertToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : basket) {
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

    public void addInBasket(String productNumber, String productPrice) {
        Product product = new Product(productNumber, productPrice);
        if (getBasket() == null) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            setBasket(products);
        } else getBasket().add(product);
    }

}
