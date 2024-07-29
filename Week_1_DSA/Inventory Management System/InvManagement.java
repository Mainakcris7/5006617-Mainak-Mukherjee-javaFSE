import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagement {
    private HashMap<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add a new product if it is not there
    public void addProduct(Product product) {
        if (!inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        } else {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        }
    }

    // Update an existing product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + product.getProductId() + " does not exist.");
        }
    }

    // Delete a product by ID
    public void deleteProduct(String productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product deleted: " + removedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Display all products
    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

}

public class InvManagement {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        Product product1 = new Product("P001", "Laptop", 10, 100);
        Product product2 = new Product("P002", "Smartphone", 20, 200);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        Product updatedProduct1 = new Product("P001", "Laptop", 15, 949.99);
        inventory.updateProduct(updatedProduct1);

        inventory.displayAllProducts();

        inventory.deleteProduct("P002");

        inventory.displayAllProducts();
    }
}