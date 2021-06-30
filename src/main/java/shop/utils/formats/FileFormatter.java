package shop.utils.formats;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum FileFormatter {

    TXT("txt"),
    JSON("json");

    private String type;

    @Override
    public String toString() {
        return type.toUpperCase(Locale.ROOT);
    }

    public static List<String> getTypeList() {
        return Arrays.asList(FileFormatter.values()).stream()
                .map(FileFormatter::getType)
                .collect(Collectors.toList());
    }
}
