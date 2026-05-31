import java.util.ArrayList;
import java.util.List;

//TODO:
//Class implements the Comparable interface
//Compares the orderNo of Orders
public class Order implements Comparable<Order> {
    private int orderNo;
    private ArrayList<MenuItem> items;
    private boolean isCompleted;

    public Order(int orderNo) {
        this.orderNo = orderNo;
        this.items = new ArrayList<>();
        this.isCompleted = false;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public boolean addItemToOrder(MenuItem item) {
        // TODO:
        // Add the item only if it is valid.
        // Return true if added, false otherwise.
        if (item != null && item.isValid()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public MenuItem getItem(String itemName) {
        // TODO:
        // Return the first item in Order with the given name, ignoring case.
        // Return null if item not found.
        for (MenuItem item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public double calculateTotalPrice() {
        // TODO:
        // Calculate and return total price of all MenuItems
        double total = 0;
        for (MenuItem item : items) {
            total += item.calculatePrice();
        }
        return total;
    }

    public void completeOrder() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public int compareTo(Order other) {
        return other.orderNo - orderNo;
    }
	
    @Override
    public String toString() {
        // TODO:
        // Return a string that includes:
        // order number, list of items, and total price.
        String result = "Order Number: " + orderNo;
        for (MenuItem item : items) {
            result += "\n" + item.getItemName();
        }
        result += "\nOrder Total: " + calculateTotalPrice();
        return result;
    }
}
