package shop.orderModel;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static shop.constantData.Constants.*;
import static shop.utils.Generator.*;

public class ProductsListGenerator {

    public static List<Product> generateProductList(int numberOfProducts) {
        return IntStream.rangeClosed(0, numberOfProducts)
                .mapToObj(i -> new Product(generateIntNumber(PRODUCT_NUMBER_SIZE), generateDoubleNumber()))
                .collect(Collectors.toList());
    }
}
