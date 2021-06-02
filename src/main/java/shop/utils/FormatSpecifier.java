package shop.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Locale;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatSpecifier {

    private static final String DEFAULT_FILE_FORMAT = FileFormat.TXT.toString();

    public static FileFormat determineOrdersFormat() {
        String fileFormat = PropertyFileReader.getProperties(Constants.FILE_FORMAT);
        if (fileFormat == null) {
            log.info("The property 'fileFormat' does not exist! TXT file format was applied.");
            return FileFormat.valueOf(DEFAULT_FILE_FORMAT);
        }
        if (!isValidFileFormat(fileFormat)) {
            log.info("Incorrect format files type! TXT file format was applied.");
            return FileFormat.valueOf(DEFAULT_FILE_FORMAT);
        } else {
            return FileFormat.valueOf(fileFormat.toUpperCase(Locale.ROOT));
        }
    }

    private static boolean isValidFileFormat(String format) {
        return FileFormat.getTypeList().contains(format);
    }
}
