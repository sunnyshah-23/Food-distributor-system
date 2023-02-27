package food;


public class Product {
    private String name;
    private int qty;
    private float price;
    private String category;
    private String brand;

    Product(String name, int qty, float price, String category, String brand) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    // Setters
    public void setName(String pname) {
        if (pname.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = pname;
    }

    public void setQty(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.qty = qty;
    }

    public void setPrice(float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");

        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be Empty");

        }
        this.category = category;
    }

    public void setBrand(String brand) {
        if (brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be negative");

        }
        this.brand = brand;
    }

  
}
