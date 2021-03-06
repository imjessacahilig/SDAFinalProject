package base;

public class Item {
    private String name;
    private int quantity;
    private int sold;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getName()+";"+this.getPrice()+";"+ this.getSold()+";"+this.getQuantity();
    }

    public double computeSales(){

        return this.sold * this.price;
    }

    public int computeRemainingItem(){

        return this.quantity - this.sold;
    }
}
