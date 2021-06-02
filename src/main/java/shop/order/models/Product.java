package shop.order.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Product implements Serializable {

    protected String productNumber;
    protected String price;

}
