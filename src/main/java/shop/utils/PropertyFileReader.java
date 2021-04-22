package shop.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.*;
import java.util.Properties;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyFileReader {

    private static Properties properties = new Properties();
    private static boolean fileWasReading = false;


    private static void fillProperties() {
        try (FileInputStream inputStream = new FileInputStream(Constants.PATH_TO_PROP)) {
            properties.load(inputStream);
            fileWasReading = true;
        } catch (IOException e) {
            log.info("Can not read file with path " + Constants.PATH_TO_PROP);
        }
    }

    public static String getProperties(String data) {
        if (!fileWasReading) {
            PropertyFileReader.fillProperties();
        }
        return properties.getProperty(data);
    }

}
