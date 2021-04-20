package shop.data;

import java.io.*;
import java.util.Properties;

public class PropertyFile {

    private static final String PATH = "src/main/resources/application.properties";
    private static Properties properties = new Properties();
    private static boolean fileWasReading = false;


    private static void fillProperties() {
        try (FileInputStream inputStream = new FileInputStream(PATH)) {
            properties.load(inputStream);
            fileWasReading = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String data) {
        if (!fileWasReading) {
            PropertyFile.fillProperties();
        }
        return properties.getProperty(data);
    }


}
