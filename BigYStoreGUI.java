import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// BigY Store GUI with creative enhancements
public class BigYStoreGUI {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> itemComboBox;
    private JLabel sizeLabel;
    private JComboBox<String> sizeComboBox;
    private JLabel toppingsLabel;
    private JSpinner toppingsSpinner;
    private JButton orderButton;
    private JTextArea outputTextArea;

    // Custom icons and fonts
    private ImageIcon pizzaIcon;
    private ImageIcon orderIcon;
    private Font titleFont;

    // Text icons
    public BigYStoreGUI() {
        frame = new JFrame("BigY Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.getContentPane().setBackground(new Color(255, 240, 210)); // Set background color

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBackground(new Color(255, 240, 210)); // Set panel background color


        // Load custom font
        titleFont = new Font("Comic Sans MS", Font.BOLD, 20);

        // Add title label with custom font
        JLabel titleLabel = new JLabel("Welcome to BigY Store!");
        titleLabel.setForeground(Color.ORANGE);
        titleLabel.setFont(titleFont);
        panel.add(titleLabel);
        panel.add(new JLabel()); // Placeholder

        // Add colorful icons for item selection
        itemComboBox = new JComboBox<>(new String[]{"Pizza"});
        itemComboBox.setRenderer(new CustomComboBoxRenderer(pizzaIcon));
        panel.add(new JLabel("Select Item:"));
        panel.add(itemComboBox);

        // Select size with visual representation
        sizeLabel = new JLabel("Select Size:");
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(sizeLabel);
        sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large", "Super"});
        sizeComboBox.setRenderer(new CustomComboBoxRenderer(null)); // No icon
        panel.add(sizeComboBox);

        // Select toppings with visual representation
        toppingsLabel = new JLabel("Select Toppings:");
        toppingsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(toppingsLabel);
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 3, 1);
        toppingsSpinner = new JSpinner(spinnerModel);
        panel.add(toppingsSpinner);

        // Animated order button with custom icon
        orderButton = new JButton("Place Order", orderIcon);
        orderButton.setFont(new Font("Arial", Font.BOLD, 16));
        orderButton.setBackground(new Color(255, 153, 51)); // Orange button color
        orderButton.setForeground(Color.BLACK); // White text color
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        panel.add(orderButton);

        // Output area with custom font and styling
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputTextArea.setBackground(new Color(255, 240, 210)); // Same as panel background
        panel.add(new JScrollPane(outputTextArea));

        frame.add(panel);
        frame.setVisible(true);
    }

    // Code for calculations
    private void placeOrder() {
        String item = (String) itemComboBox.getSelectedItem();
        String size = (String) sizeComboBox.getSelectedItem();
        int toppings = (int) toppingsSpinner.getValue();

        double basePrice = 0;
        switch (size) {
            case "Small":
                basePrice = 5;
                break;
            case "Medium":
                basePrice = 10;
                break;
            case "Large":
                basePrice = 15;
                break;
            case "Super":
                basePrice = 20;
                break;
        }

        double additionalCost = toppings * 0.5;

        double totalCost = basePrice + additionalCost;

        outputTextArea.setText("Item: " + item + "\nSize: " + size + "\nToppings: " + toppings +
                "\nTotal Cost: $" + totalCost);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BigYStoreGUI();
            }
        });
    }

    // Custom ComboBox renderer to display icons
    private class CustomComboBoxRenderer extends DefaultListCellRenderer {
        private ImageIcon icon;

        public CustomComboBoxRenderer(ImageIcon icon) {
            this.icon = icon;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (icon != null) {
                setIcon(icon);
            }
            return this;
        }
    }
}
