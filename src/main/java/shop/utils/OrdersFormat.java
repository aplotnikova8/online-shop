package shop.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrdersFormat {

    TXT ("txt"),
    JSON ("json");

    private String type;

    @Override
    public String toString() {
        return type;
    }
}
