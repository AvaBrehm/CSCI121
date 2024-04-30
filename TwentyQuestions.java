import java.io.*;
import java.util.Scanner;

// Node class representing a node in the binary tree
class Node implements Serializable {
    String data; // Data stored in the node
    Node yes;    // Pointer to the "yes" subtree
    Node no;     // Pointer to the "no" subtree

    // Constructor to create a new node
    public Node(String data) {
        this.data = data;
        this.yes = null;
        this.no = null;
    }
}

// Main class for the 20 questions game
public class TwentyQuestions {
    private Node root;     // Root node of the binary tree
    private transient Scanner scanner; // Scanner for user input

    // Constructor to initialize the game
    public TwentyQuestions() {
        root = new Node("Is it a living thing?");
        scanner = new Scanner(System.in);
    }

    // Method to construct the initial binary tree
    public void constructTree() {
        // Constructing the initial tree with some playful questions
        root.yes = new Node("Is it fluffy?");
        root.no = new Node("Is it an object?");
        root.yes.yes = new Node("Is it a cat?");
        root.yes.no = new Node("Can it fly?");
        root.yes.no.yes = new Node("Is it a bird?");
        root.yes.no.no = new Node("Is it a bat?");
        root.no.yes = new Node("Can you sit on it?");
        root.no.no = new Node("Is it a vehicle?");
    }

    // Method to play the game
    public void playGame() {
        Node current = root;

        while (current != null) {
            System.out.println(current.data + " (yes/no)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("yes")) {
                if (current.yes == null) {
                    System.out.println("Yay! I guessed it right!");
                    break;
                }
                current = current.yes;
            } else if (input.equals("no")) {
                if (current.no == null) {
                    addNewObject(current);
                    break;
                }
                current = current.no;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    // Method to add a new object and question to the tree
    private void addNewObject(Node parent) {
        System.out.println("I give up! What is the correct answer?");
        String newAnswer = scanner.nextLine();

        System.out.println("Give me a fun question that distinguishes " + newAnswer + " from " + parent.data);
        String newQuestion = scanner.nextLine();

        System.out.println("And what would be the answer to that question for " + newAnswer + "? (yes/no)");
        String answerToNewQuestion = scanner.nextLine().toLowerCase();

        Node newNode = new Node(newAnswer);
        Node oldNode = new Node(parent.data);

        if (answerToNewQuestion.equals("yes")) {
            parent.data = newQuestion;
            parent.yes = newNode;
            parent.no = oldNode;
        } else {
            parent.data = newQuestion;
            parent.yes = oldNode;
            parent.no = newNode;
        }
    }

    // Method to save the tree state to a file
    public void saveTreeToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(root);
            System.out.println("Tree state saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tree state: " + e.getMessage());
        }
    }

    // Method to load the tree state from a file
    public void loadTreeFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            root = (Node) ois.readObject();
            System.out.println("Tree state loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tree state: " + e.getMessage());
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        TwentyQuestions game = new TwentyQuestions();
        game.constructTree();

        // Load tree state from file if exists
        File file = new File("treeState.ser");
        if (file.exists()) {
            game.loadTreeFromFile("treeState.ser");
        }

        // Play the game
        game.playGame();

        // Save tree state to file
        game.saveTreeToFile("treeState.ser");
    }
}

