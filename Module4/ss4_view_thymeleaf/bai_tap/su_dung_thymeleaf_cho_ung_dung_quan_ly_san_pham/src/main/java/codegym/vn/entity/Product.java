package codegym.vn.entity;

public class Product {
    int id;
    String type;
    String name;
    double price;
    String origin;

    public Product() {
    }

    public Product(int id, String type ,String name, double price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
