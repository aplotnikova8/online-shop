package shop.utils;

import lombok.extern.java.Log;

@Log
public class FormatSpecifier {

    public static String specifyFormat() throws NullPointerException {
        return PropertyFileReader.getProperties(Constants.FILE_FORMAT);
    }

    public static boolean determineOrdersFormat() throws IllegalArgumentException{
        String myFormat = specifyFormat();
        boolean jsonFormat = false;
        try {
            if (myFormat.equals(OrdersFormat.JSON.toString())) {
                jsonFormat = true;
            } else {
                if (!myFormat.equals(OrdersFormat.TXT.toString())) {
                    throw new IllegalArgumentException();
                }
            }
        }
        catch (NullPointerException e) {
            log.info("The property 'format' does not exist");
        }
        return jsonFormat;
    }
}
