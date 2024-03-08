import java.util.Arrays;
import java.util.Scanner;

// Class representing a delicious Pizza
class Pizza {
    private String[] toppings;
    private double price;

    // Constructor to create a mouthwatering Pizza with toppings and calculate its price
    public Pizza(String[] toppings, int numToppings) {
        // Store the delectable toppings
        this.toppings = Arrays.copyOf(toppings, numToppings);

        // Calculate the price based on the richness of toppings
        double basePrice = 14;
        double perToppingPrice = 2;
        this.price = basePrice + perToppingPrice * numToppings;
    }

    // Method to represent the scrumptious Pizza as a string
    public String toString() {
        return "🍕 Pizza toppings: " + Arrays.toString(toppings) + "\n💰 Price: $" + price;
    }

    // Getter method for retrieving the price of this irresistible Pizza
    public double getPrice() {
        return price;
    }
}

// Subclass of Pizza for delivering delightful Pizzas to customers
class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    // Constructor to create a DeliveryPizza with toppings, delivery address, and calculate the delivery fee
    public DeliveryPizza(String[] toppings, String deliveryAddress, int numToppings) {
        // Invoke the superclass constructor to prepare the delicious Pizza
        super(toppings, numToppings);

        // Determine the delivery fee based on the lavishness of the Pizza
        if (super.getPrice() > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }

        // Set the destination for this heavenly Pizza
        this.deliveryAddress = deliveryAddress;
    }

    // Method to represent the DeliveryPizza as a string, adding delivery details
    public String toString() {
        return super.toString() + "\n🚚 Delivery Fee: $" + deliveryFee + "\n📍 Delivery Address: " + deliveryAddress;
    }
}

// Main class to serve as the entrance for Pizza lovers
public class DemoPizza {
    private static final String QUIT = "QUIT";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Greet the Pizza enthusiasts
        System.out.println("🍕 Welcome to the Ultimate Pizza Ordering System! 🍕");

        // Prepare to gather the desired toppings
        String[] toppings = new String[10];
        int numToppings = 0;

        // Prompt the user to choose their favorite toppings, until satisfied or quitting
        while (numToppings < 10) {
            System.out.print("🔍 Enter a topping (or type QUIT to finish): ");
            String topping = scanner.nextLine().trim();
            if (topping.equalsIgnoreCase(QUIT)) {
                break;
            }
            toppings[numToppings++] = topping;
        }

        // Inquire if the customer prefers delivery or not
        System.out.print("🛵 Do you want delivery? (yes/no): ");
        String deliveryChoice = scanner.nextLine().trim();
        if (deliveryChoice.equalsIgnoreCase("yes")) {
            // If delivery is desired, prompt for the delivery address and create a DeliveryPizza
            System.out.print("🏠 Enter delivery address: ");
            String deliveryAddress = scanner.nextLine().trim();
            DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, deliveryAddress, numToppings);
            System.out.println(deliveryPizza);
        } else {
            // If delivery is not requested, craft a delightful Pizza for immediate enjoyment
            Pizza pizza = new Pizza(toppings, numToppings);
            System.out.println(pizza);
        }

        // Bid farewell to the satisfied customers
        System.out.println("🍕 Enjoy your Pizza! Bon appétit! 🍕");

        scanner.close();
    }
}
