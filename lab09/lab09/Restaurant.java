import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Order> pendingOrders;
    private static List<MenuItem> menu = new ArrayList<>();
    private static int nextOrderNo = 1000;

    public Restaurant() {
        ingredients = new ArrayList<>();
        pendingOrders = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Ingredient findIngredientByName(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                return ingredient;
            }
        }
        return null;
    }

    public Order createNewOrder() {
        // TODO:
		//Create new Order with nextOrderNo
		//Increments nextOrderNo and returns Order
        Order order = new Order(nextOrderNo);
        nextOrderNo++;
        return order;
    }

    public void addPendingOrder(Order order) {
        // TODO:
		// Adds order to list of pendingOrders
		// if order does not already exist.
        if (order == null) {
            return;
        }
        if (findPendingOrder(order.getOrderNo()) == null) {
            pendingOrders.add(order);
        }
    }

    public Order findPendingOrder(int orderNo) {
        // TODO:
		// Returns order with given orderNo, null if not found
        for (Order order : pendingOrders) {
            if (order.getOrderNo() == orderNo) {
                return order;
            }
        }
        return null;
    }
    public boolean addItemToMenu(MenuItem item) {
        // TODO:
        // Add only valid items to the menu.
        // Return true if added, false otherwise.
        if (item != null && item.isValid()) {
            menu.add(item);
            return true;
        }
        return false;
    }
}
