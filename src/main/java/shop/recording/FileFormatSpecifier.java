package shop.recording;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import shop.utils.constants.GlobalConstants;
import shop.utils.PropertyFileReader;
import shop.utils.formats.FileFormatter;

import java.util.Locale;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileFormatSpecifier {

    private static final String DEFAULT_FILE_FORMAT = FileFormatter.TXT.toString();

    public static FileFormatter determineOrdersFormat() {
        String fileFormat = PropertyFileReader.getProperties(GlobalConstants.FILE_FORMAT);
        return (!fileFormat.isEmpty() && isValid(fileFormat)) ? FileFormatter.valueOf(fileFormat.toUpperCase(Locale.ROOT)) : (FileFormatter.valueOf(DEFAULT_FILE_FORMAT));
    }

    private static boolean isValid(String format) {
        return FileFormatter.getTypeList().contains(format);
    }
}
