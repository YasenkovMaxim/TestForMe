package TasksTest.ten;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {
    private String name;
    private double price;
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Map<String, Double> averagePricePerCategory(List<Product> products) {
        Map<String, Double> mapAveragePricePerCategory = products.stream()
                .filter(product -> product.getPrice() > 0)
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));
        return mapAveragePricePerCategory;
    }
    public void printAveragePrices(Map<String, Double> averages) {
        averages.forEach((category, avgPrice) ->
                System.out.printf("%s: %.2f%n", category, avgPrice));
    }
}
