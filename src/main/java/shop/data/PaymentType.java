package shop.data;

public enum PaymentType {

    MC_CC ("MC_CC"),
    VISA_CC ("VISA_CC"),
    CASH ("CASH"),
    GC ("GC");

    private String title;

    PaymentType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
