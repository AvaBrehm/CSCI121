// Importing the Scanner class from java.util package
import java.util.Scanner;

// Main class for running the party planner program
public class UseDinnerParty {
    public static void main(String[] args) {
        // Creating a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Creating a Party object
        Party party = new Party();

        // Creating a DinnerParty object
        DinnerParty dinnerParty = new DinnerParty();

        // Displaying a welcome message
        System.out.println("🎉 Welcome to Party Planner 🎉");
        System.out.println("----------------------------------");

        // Asking the user to enter the number of guests for the party
        System.out.print("Enter number of guests for the party: ");
        int guests = scanner.nextInt();
        party.setNumberOfGuests(guests);

        // Displaying the number of guests for the party and inviting them
        System.out.println("\nThe party has " + party.getNumberOfGuests() + " guests!");
        party.displayInvitation();

        // Prompting the user to plan the dinner party
        System.out.println("\n🍽️ Now let's plan the Dinner Party 🍽️");
        System.out.println("----------------------------------------");

        // Asking the user to enter the number of guests for the dinner party
        System.out.print("Enter number of guests for the dinner party: ");
        int dinnerGuests = scanner.nextInt();
        dinnerParty.setNumberOfGuests(dinnerGuests);

        // Asking the user to choose the menu for the dinner party
        System.out.print("\n What's on the menu? (1 for chicken, 2 for fish): ");
        int choice = scanner.nextInt();
        dinnerParty.setDinnerChoice(choice);

        // Displaying the details of the dinner party, including the dinner choice
        System.out.println("\n The dinner party has " + dinnerParty.getNumberOfGuests() + " guests!");
        System.out.print(" Dinner choice: ");
        System.out.println(dinnerParty.getDinnerChoice() == 1 ? "🍗 Chicken" : "🐟 Fish");


        System.out.println("\nThank you for partying with us!");
    }
}
