package TasksTest.six;

class Product {
    String name;
    String category;
    int price;

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + category + ", " + price + "$)";
    }
}
