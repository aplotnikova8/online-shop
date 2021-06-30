package shop.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import shop.utils.constants.GlobalConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyFileReader {

    private static final Properties properties = new Properties();
    private static boolean fileWasReading = false;

    private static void fillProperties() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(GlobalConstants.PATH_TO_PROP))) {
            properties.load(br);
            fileWasReading = true;
        } catch (IOException e) {
            log.info("Can not read file with path " + GlobalConstants.PATH_TO_PROP);
        }
    }

    public static String getProperties(String data) {
        if (!fileWasReading) {
            PropertyFileReader.fillProperties();
        }
        return properties.getProperty(data);
    }

}
