// Car.java
// Class representing a car object with year, model, color, and price
public class Car {
    private int year;       // Year of the car
    private Model model;    // Model of the car
    private Color color;    // Color of the car
    private double price;   // Price of the car

    // Constructor to initialize Car object with year, model, color, and price
    public Car(int year, Model model, Color color, double price) {
        this.year = year;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    // Method to display details of the car
    public void display() {
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + price);
        System.out.println("Description: This " + color.toString().toLowerCase() + " " + model.toString().toLowerCase() + " from " + year + " is available for $" + price + ".");
    }
}

