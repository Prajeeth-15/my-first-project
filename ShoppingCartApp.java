import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartApp {

    // Product class
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String toString() {
            return name + " - ₹" + price;
        }
    }

    // Cart class
    static class Cart {
        ArrayList<Product> items = new ArrayList<>();

        public void addProduct(Product p) {
            items.add(p);
            System.out.println(p.name + " added to cart.");
        }

        public void viewCart() {
            if (items.isEmpty()) {
                System.out.println("Cart is empty.");
                return;
            }
            System.out.println("🛒 Your Cart:");
            double total = 0;
            for (int i = 0; i < items.size(); i++) {
                Product p = items.get(i);
                System.out.println((i + 1) + ". " + p);
                total += p.price;
            }
            System.out.println("Total: ₹" + total);
        }

        public void removeProduct(int index) {
            if (index >= 0 && index < items.size()) {
                Product removed = items.remove(index);
                System.out.println(removed.name + " removed.");
            } else {
                System.out.println("Wrong item number.");
            }
        }

        public double getTotal() {
            double total = 0;
            for (Product p : items) total += p.price;
            return total;
        }
    }

    // Main method
    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Shopping Cart Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Product");
            System.out.println("4. Checkout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ₹");
                    double price = sc.nextDouble();
                    cart.addProduct(new Product(name, price));
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    cart.viewCart();
                    System.out.print("Enter item number to remove: ");
                    int itemNo = sc.nextInt();
                    cart.removeProduct(itemNo - 1);
                    break;
                case 4:
                    System.out.println("Total bill: ₹" + cart.getTotal());
                    System.out.println("🛍️ Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
