package shop.converters.fabrics;

import lombok.experimental.UtilityClass;
import shop.converters.ConverterJsonToOrders;
import shop.converters.ConverterToOrders;
import shop.converters.ConverterTxtToOrder;
import shop.recording.FileFormatSpecifier;

@UtilityClass
public class ConvertersFabric {

    public static ConverterToOrders createConverter() {
        String format = FileFormatSpecifier.determineOrdersFormat().getType();
        switch (format) {
            case "txt":
                return new ConverterTxtToOrder();
            case "json":
                return new ConverterJsonToOrders();
            default:
                throw new IllegalArgumentException("Invalid file format" + format);
        }
    }

}
