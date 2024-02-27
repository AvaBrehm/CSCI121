import java.util.Scanner;

public class BadSubscriptCaught {
    // Main method
    public static void main(String[] args) {
        // Declare an array of 10 first names
        String[] firstNames = {"John", "Alice", "Bob", "Emma", "Michael", "Olivia", "David", "Sophia", "James", "Emily"};


        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the position of the name you want to display (0-9): ");
            int index = scanner.nextInt();


            System.out.println("Name at position " + index + ": " + firstNames[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block to handle ArrayIndexOutOfBoundsException
            // Display error message if a number that is out of range
            System.out.println("Error: Index out of bounds. Please enter a number between 0 and 9.");
        } finally {
            scanner.close();
        }
    }
}
