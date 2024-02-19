import java.util.Scanner;

public class UseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Party aParty = new Party();

        System.out.print("Enter number of guests for the party >> ");
        int guests = scanner.nextInt();
        aParty.setNumberOfGuests(guests);

        System.out.println("The party has " + aParty.getNumberOfGuests() + " guests");
        aParty.displayInvitation();
    }
}
