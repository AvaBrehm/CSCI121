import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Party party = new Party();
        DinnerParty dinnerParty = new DinnerParty();

        System.out.println("🎉 Welcome to Party Planner 🎉");
        System.out.println("----------------------------------");
        System.out.print("Enter number of guests for the party: ");
        int guests = scanner.nextInt();
        party.setNumberOfGuests(guests);

        System.out.println("\nThe party has " + party.getNumberOfGuests() + " guests!");
        party.displayInvitation();

        System.out.println("\n🍽️ Now let's plan the Dinner Party 🍽️");
        System.out.println("----------------------------------------");
        System.out.print("Enter number of guests for the dinner party: ");
        int dinnerGuests = scanner.nextInt();
        dinnerParty.setNumberOfGuests(dinnerGuests);

        System.out.print("\n What's on the menu? (1 for chicken, 2 for fish): ");
        int choice = scanner.nextInt();
        dinnerParty.setDinnerChoice(choice);

        System.out.println("\n The dinner party has " + dinnerParty.getNumberOfGuests() + " guests!");
        System.out.print(" Dinner choice: ");
        System.out.println(dinnerParty.getDinnerChoice() == 1 ? "🍗 Chicken" : "🐟 Fish");

        System.out.println("\nThank you for partying with us!");
    }
}
