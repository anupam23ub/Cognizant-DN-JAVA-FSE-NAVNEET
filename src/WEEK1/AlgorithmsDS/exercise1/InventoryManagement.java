package WEEK1.AlgorithmsDS.exercise1;

import java.util.HashMap;
import java.util.Map;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class InventoryManagement {
    private Map<String, Product> inventory;

    public InventoryManagement() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = newQuantity;
            p.price = newPrice;
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }
}
