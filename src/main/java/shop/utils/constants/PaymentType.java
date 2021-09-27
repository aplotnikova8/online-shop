package shop.utils.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentType {

    MC_CC("MC_CC"),
    VISA_CC("VISA_CC"),
    CASH("CASH"),
    GC("GC");

    private String title;

    @Override
    public String toString() {
        return title;
    }

}
