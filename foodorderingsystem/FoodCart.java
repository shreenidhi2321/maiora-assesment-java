package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class FoodCart {
	private List<FoodItem> items = new ArrayList<>();
    private String specialInstructions = "";

    public void addItem(FoodItem item) {
        items.add(item);
        System.out.println(item.getName() + " added to cart.");
    }

    public void setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }

    public double calculateTotal(double taxRate, double deliveryCharge) {
        double subtotal = items.stream().mapToDouble(FoodItem::getPrice).sum();
        double tax = subtotal * taxRate;
        return subtotal + tax + deliveryCharge;
    }

    public void displayCart(double taxRate, double deliveryCharge) {
        System.out.println("\n Your Cart:");
        items.forEach(item -> System.out.println("- " + item));
        System.out.println("Special Instructions: " + (specialInstructions.isEmpty() ? "None" : specialInstructions));
        System.out.printf("Total (incl. tax & delivery): ₹%.2f%n", calculateTotal(taxRate, deliveryCharge));
    }

}
