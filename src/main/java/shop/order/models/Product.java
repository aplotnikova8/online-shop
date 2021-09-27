package shop.order.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Product implements Serializable {

    protected String productNumber;
    protected String price;

}
