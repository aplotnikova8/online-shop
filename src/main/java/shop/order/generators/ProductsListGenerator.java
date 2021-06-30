package shop.order.generators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.order.models.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static shop.utils.constants.GlobalConstants.*;
import static shop.utils.Generator.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsListGenerator {

    public static List<Product> generateProductList(int numberOfProducts) {
        return IntStream.rangeClosed(0, numberOfProducts)
                .mapToObj(i -> new Product(generateIntNumber(PRODUCT_NUMBER_SIZE), generateDoubleNumber()))
                .collect(Collectors.toList());
    }

}
