package shop.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum FileFormat {

    TXT("txt"),
    JSON("json");

    private String type;

    @Override
    public String toString() {
        return type.toUpperCase(Locale.ROOT);
    }

    public static List<String> getTypeList() {
        return Arrays.asList(FileFormat.values()).stream()
                .map(FileFormat::getType)
                .collect(Collectors.toList());
    }
}
