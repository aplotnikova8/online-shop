package shop.orderCreation.model;

public class Order {

    private String orderNumber;
    private String customersName;
    private Boolean loyalty;
    private String date;
    private String productNumber;
    private String price;
    private String paymentType;

    public Order(String orderNumber, String customersName, Boolean loyalty, String date, String productNumber, String price, String type) {
        this.orderNumber = orderNumber;
        this.customersName = customersName;
        this.loyalty = loyalty;
        this.date = date;
        this.productNumber = productNumber;
        this.price = price;
        this.paymentType = type;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomersName() {
        return customersName;
    }

    public Boolean getLoyalty() {
        return loyalty;
    }

    public String getDate() {
        return date;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return orderNumber +
                "|" + customersName +
                "|" + loyalty +
                "|" + date +
                "|" + productNumber +
                "|" + price +
                "|" + paymentType;
    }
}
