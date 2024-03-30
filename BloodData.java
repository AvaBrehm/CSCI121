import java.util.Scanner;

// Enum representing different blood types
enum BloodType {
    O, A, B, AB;
}

// Class representing the blood type and Rh factor of a patient
public class BloodData {
    private BloodType bloodType; // The type of blood (e.g., O, A, B, AB)
    private char rhFactor; // The Rh factor of the blood (e.g., + or -)

    // Default constructor sets blood type to O and Rh factor to +
    public BloodData() {
        this.bloodType = BloodType.O;
        this.rhFactor = '+';
    }

    // Constructor allowing custom blood type and Rh factor
    public BloodData(BloodType bloodType, char rhFactor) {
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
    }

    // Getter and setter methods for BloodData fields
    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public char getRhFactor() {
        return rhFactor;
    }

    public void setRhFactor(char rhFactor) {
        this.rhFactor = rhFactor;
    }
}

// Class to test BloodData functionality
class TestBloodData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Object 1: Default BloodData
        BloodData defaultBloodData = new BloodData();

        // Object 2: Custom BloodData from user input
        System.out.println("Let's create the blood data for a patient...");
        System.out.println("Please enter the patient's blood type (O, A, B, AB): ");
        BloodType bloodType = BloodType.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Please enter the patient's Rh factor (+ or -): ");
        char rhFactor = scanner.nextLine().charAt(0);
        BloodData userInputBloodData = new BloodData(bloodType, rhFactor);

        // Display details of both BloodData objects
        System.out.println("Here are the details of the default blood data:");
        displayBloodDataDetails(defaultBloodData);
        System.out.println("\nAnd here are the details of the blood data you entered:");
        displayBloodDataDetails(userInputBloodData);

        // Update default object with user input values
        defaultBloodData.setBloodType(bloodType);
        defaultBloodData.setRhFactor(rhFactor);

        // Display details of default object after changes
        System.out.println("\nNow, the default blood data has been updated with your input:");
        displayBloodDataDetails(defaultBloodData);

        scanner.close();
    }

    // Method to display BloodData details
    private static void displayBloodDataDetails(BloodData bloodData) {
        System.out.println("Blood Type: " + bloodData.getBloodType());
        System.out.println("Rh Factor: " + bloodData.getRhFactor());
    }
}

// Class representing a patient
class Patient {
    private int idNumber; // The unique identification number of the patient
    private int age; // The age of the patient
    private BloodData bloodData; // The blood data of the patient

    // Default constructor with initial values
    public Patient() {
        this.idNumber = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    // Constructor with custom values
    public Patient(int idNumber, int age, BloodData bloodData) {
        this.idNumber = idNumber;
        this.age = age;
        this.bloodData = bloodData;
    }

    // Getter methods for patient fields
    public int getIdNumber() {
        return idNumber;
    }

    public int getAge() {
        return age;
    }

    public BloodData getBloodData() {
        return bloodData;
    }
}

