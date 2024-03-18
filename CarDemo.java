import java.util.Scanner;

public class CarDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Emporium!");

        // Prompt the user to input details for a custom car
        System.out.print("Enter the year of the car: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the model of the car (SEDAN, CONVERTIBLE, MINIVAN): ");
        String modelStr = scanner.nextLine().toUpperCase();
        Model model = Model.valueOf(modelStr);

        System.out.print("Enter the color of the car (BLACK, BLUE, GREEN, RED, WHITE, YELLOW): ");
        String colorStr = scanner.nextLine().toUpperCase();
        Color color = Color.valueOf(colorStr);

        System.out.print("Enter the price of the car: $");
        double price = scanner.nextDouble();

        // Create a custom car object
        Car customCar = new Car(year, model, color, price);

        // Display details of the custom car
        System.out.println("\nYour car is ready!\n");
        System.out.println("Here are the details of your custom car:");
        customCar.display();

        // Close the scanner
        scanner.close();
    }
}
