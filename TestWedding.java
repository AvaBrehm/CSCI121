import java.time.LocalDate;
import java.util.Scanner;

// Class representing a person
class Person {
    private String firstName;

    // Constructor requiring first name
    public Person(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for first name
    public String getFirstName() {
        return firstName;
    }

}

// Class representing a couple
class Couple {
    private Person bride;
    private Person groom;

    // Constructor requiring bride and groom
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // Getter method for bride
    public Person getBride() {
        return bride;
    }

    // Getter method for groom
    public Person getGroom() {
        return groom;
    }
}

// Class representing a wedding
class Wedding {
    private Couple couple;
    private LocalDate weddingDate;
    private String location;
    private String theme;

    // Constructor requiring couple, wedding date, location, and theme
    public Wedding(Couple couple, LocalDate weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
    }

    // Getter method for couple
    public Couple getCouple() {
        return couple;
    }

    // Getter method for wedding date
    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    // Getter method for location
    public String getLocation() {
        return location;
    }

    // Method to congratulate the couple
    public void congratulateCouple() {
        System.out.println("\uD83C\uDF89Congratulations to " + couple.getBride().getFirstName() + " and " + couple.getGroom().getFirstName() + " on their wedding!");
        System.out.println("May your love continue to grow stronger with each passing day. Best wishes for a lifetime of happiness together!");
    }
}

// Test class
public class TestWedding {
    public static void main(String[] args) {
        // Prompting the user for data
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Wedding Planner!");
        System.out.println("Let's plan a beautiful wedding...");

        System.out.println("\n Enter bride's first name: ");
        String brideFirstName = scanner.nextLine();

        System.out.println("Enter groom's first name: ");
        String groomFirstName = scanner.nextLine();

        System.out.println("Enter wedding date (YYYY-MM-DD): ");
        String weddingDateInput = scanner.nextLine();
        LocalDate weddingDate = LocalDate.parse(weddingDateInput);

        System.out.println("Enter wedding location: ");
        String location = scanner.nextLine();


        // Creating a couple
        Person bride = new Person(brideFirstName);
        Person groom = new Person(groomFirstName);
        Couple couple = new Couple(bride, groom);

        // Creating a Wedding object
        Wedding wedding = new Wedding(couple, weddingDate, location);

        // Displaying details and congratulations message
        System.out.println("\n--- Wedding Details ---");
        System.out.println("Welcome to the Wedding of " + wedding.getCouple().getBride().getFirstName() + " and " + wedding.getCouple().getGroom().getFirstName() + "!");
        System.out.println("🎉 Date: " + wedding.getWeddingDate());
        System.out.println("🏰 Location: " + wedding.getLocation());
        // Congratulating the couple
        wedding.congratulateCouple();
    }
}
