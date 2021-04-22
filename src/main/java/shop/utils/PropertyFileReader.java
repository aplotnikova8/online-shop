package shop.fileFormatting;

import shop.constantData.Constants;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader {

    private static Properties properties = new Properties();
    private static boolean fileWasReading = false;


    private static void fillProperties() {
        try (FileInputStream inputStream = new FileInputStream(Constants.PATH_WITH_PROP)) {
            properties.load(inputStream);
            fileWasReading = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String data) {
        if (!fileWasReading) {
            PropertyFileReader.fillProperties();
        }
        return properties.getProperty(data);
    }


}
