import java.util.Arrays;
import java.util.Comparator;

public class ObjectSortingExample {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop", 999.99, 25),
            new Product("Phone", 699.99, 50),
            new Product("Tablet", 299.99, 10),
            new Product("Monitor", 199.99, 35)
        };
        
        System.out.println("Original array:");
        printArray(products);
        
        // Sort by name
        Arrays.sort(products, Comparator.comparing(Product::getName));
        System.out.println("\nSorted by name:");
        printArray(products);
        
        // Sort by price
        Arrays.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("\nSorted by price:");
        printArray(products);
        
        // Sort by stock descending
        Arrays.sort(products, Comparator.comparingInt(Product::getStock).reversed());
        System.out.println("\nSorted by stock (descending):");
        printArray(products);
        
        // Sort by price then stock
        Arrays.sort(products, Comparator
            .comparingDouble(Product::getPrice)
            .thenComparingInt(Product::getStock));
        System.out.println("\nSorted by price then stock:");
        printArray(products);
    }
    
    private static void printArray(Product[] products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    
    @Override
    public String toString() {
        return String.format("%-10s $%.2f (%d in stock)", name, price, stock);
    }
}