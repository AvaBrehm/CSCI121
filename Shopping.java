import java.util.ArrayList;

// Represents a grocery item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Represents a shopper's desire to purchase a given item in a given quantity
class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Calculate the price for the current order
    public double getOrderPrice() {
        return item.getPrice() * quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}

// Represents a shopping cart that stores ItemOrders
class ShoppingCart {
    private ArrayList<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    // Add an item order to the cart
    public void addItemOrder(ItemOrder itemOrder) {
        orders.add(itemOrder);
    }

    // Remove an item order from the cart
    public void removeItemOrder(ItemOrder itemOrder) {
        orders.remove(itemOrder);
    }

    // Calculate the total price of all item orders in the cart
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ItemOrder order : orders) {
            totalPrice += order.getOrderPrice();
        }
        return totalPrice;
    }

    // Search for a specific item order in the cart
    public boolean searchItemOrder(ItemOrder itemOrder) {
        return orders.contains(itemOrder);
    }
}

public class Shopping {
    public static void main(String[] args) {
        // Create items
        Item tissues = new Item("Tissues", 3.0);
        Item milk = new Item("Milk", 2.0);

        // Create item orders
        ItemOrder tissueOrder = new ItemOrder(tissues, 9);
        ItemOrder milkOrder = new ItemOrder(milk, 10);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add item orders to the shopping cart
        cart.addItemOrder(tissueOrder);
        cart.addItemOrder(milkOrder);

        // Remove an item order from the shopping cart
        cart.removeItemOrder(milkOrder);

        // Display the total price of all item orders in the shopping cart
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
