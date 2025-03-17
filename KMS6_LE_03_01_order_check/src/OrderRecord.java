// class that designs the Order objects

public class OrderRecord {
    private String description;
    private int quantity;
    private double unitPrice;

    public OrderRecord(String description, int quantity, double unitPrice) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


    // toString method used to set the output
    @Override
    public String toString() {
        return "Description: " + description + "\n" +
                "Quantity: " + quantity + "\n" +
                "Unit Price: " + unitPrice;
    }
}
