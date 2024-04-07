import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Node class for the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize the node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class containing various linked list operations
class LinkedList {
    public Node head;

    // Method to append data to the linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // Method to remove the node after a given node
    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    // Method to create a copy of the linked list
    public LinkedList copy() {
        LinkedList copiedList = new LinkedList();
        Node current = head;
        while (current != null) {
            copiedList.append(current.data);
            current = current.next;
        }
        return copiedList;
    }

    // Method to remove nodes with duplicate data
    public void removeDuplicate(int key) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Method to find the maximum value in the linked list
    public int maxValue() {
        if (head == null) {
            return 0;
        }
        int maxVal = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > maxVal) {
                maxVal = current.data;
            }
            current = current.next;
        }
        return maxVal;
    }
}

// Class for the GUI of the linked list operations
class LinkedListGUI {
    private JFrame frame;
    private LinkedList linkedList;

    // Constructor to initialize the GUI
    public LinkedListGUI() {
        linkedList = new LinkedList();
        initialize();
    }

    // Method to set up the user interface
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Linked List Operations");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        frame.getContentPane().add(textField);

        JButton appendButton = new JButton("Append");
        appendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dataStr = textField.getText();
                if (dataStr.matches("\\d+")) {
                    int data = Integer.parseInt(dataStr);
                    linkedList.append(data);
                    textField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number.");
                }
            }
        });
        frame.getContentPane().add(appendButton);

        JButton removeAfterButton = new JButton("Remove After");
        removeAfterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (linkedList != null && linkedList.head != null) {
                    linkedList.removeAfter(linkedList.head);
                    JOptionPane.showMessageDialog(frame, "Node removed after the head.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Linked list is empty.");
                }
            }
        });
        frame.getContentPane().add(removeAfterButton);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (linkedList != null && linkedList.head != null) {
                    LinkedList copiedList = linkedList.copy();
                    JOptionPane.showMessageDialog(frame, "Linked list copied.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Linked list is empty.");
                }
            }
        });
        frame.getContentPane().add(copyButton);

        JButton removeDuplicateButton = new JButton("Remove Duplicate");
        removeDuplicateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (linkedList != null && linkedList.head != null) {
                    String keyStr = textField.getText();
                    if (keyStr.matches("\\d+")) {
                        int key = Integer.parseInt(keyStr);
                        linkedList.removeDuplicate(key);
                        JOptionPane.showMessageDialog(frame, "All nodes with specified value removed.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Linked list is empty.");
                }
            }
        });
        // Adding a button to remove duplicate elements from the linked list
        frame.getContentPane().add(removeDuplicateButton);

// Creating a button to find the maximum value in the linked list
        JButton maxValueButton = new JButton("Max Value");

// Adding action listener to the maximum value button
        maxValueButton.addActionListener(new ActionListener() {
            // Handling action performed when the button is clicked
            public void actionPerformed(ActionEvent e) {
                // Checking if the linked list exists and is not empty
                if (linkedList != null && linkedList.head != null) {
                    // Finding the maximum value in the linked list
                    int maxVal = linkedList.maxValue();
                    // Displaying the maximum value in a dialog
                    JOptionPane.showMessageDialog(frame, "Maximum value: " + maxVal);
                } else {
                    // Displaying a message if the linked list is empty
                    JOptionPane.showMessageDialog(frame, "Linked list is empty.");
                }
            }
        });

// Adding the maximum value button to the frame
        frame.getContentPane().add(maxValueButton);

// Making the frame visible to display the buttons
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new LinkedListGUI();
    }
}
