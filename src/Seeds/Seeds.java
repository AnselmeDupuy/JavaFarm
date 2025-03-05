package Seeds;

public abstract class Seeds {
    private String name;
    private int price = 25;
    private int quantity;

    public Seeds(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuandity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuandity(int quantity) {
        this.quantity -= quantity;
    }
}
