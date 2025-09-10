package foodorderingsystem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingSystem {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        List<FoodItem> menu = Arrays.asList(
            new FoodItem("Pizza", 250),
            new FoodItem("Burger", 150),
            new FoodItem("Pasta", 200),
            new FoodItem("Fries", 100),
            new FoodItem("Coke", 50)
        );

        FoodCart cart = new FoodCart();
        double taxRate = 0.08; // 8% tax
        double deliveryCharge = 40.0;
        
        System.out.println("ðŸ?” Welcome to JavaBites Food Ordering!");
        System.out.println("ðŸ“‹ Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        while (true) {
            System.out.print("\nEnter item number to add to cart (0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            if (choice >= 1 && choice <= menu.size()) {
                cart.addItem(menu.get(choice - 1));
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.nextLine(); 
        System.out.print("Any special instructions for your order? ");
        String instructions = scanner.nextLine();
        cart.setSpecialInstructions(instructions);

        cart.displayCart(taxRate, deliveryCharge);
        System.out.println("\nâœ… Order placed successfully. Thank you!");
        scanner.close();


	}

	
}
