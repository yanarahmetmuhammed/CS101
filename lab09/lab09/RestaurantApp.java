import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class RestaurantApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        seedData(restaurant);
        runMenu(restaurant);
    }

    private static void seedData(Restaurant restaurant) {
        Ingredient dough = new Ingredient("Dough", 3.0, true, false);
        Ingredient tomato = new Ingredient("Tomato", 2.0, true, false);
        Ingredient mushroom = new Ingredient("Mushroom", 4.0, true, false);
        Ingredient cheese = new Ingredient("Cheese", 3.0, true, true);
        Ingredient beef = new Ingredient("Beef", 5.0, false, false);
        Ingredient chicken = new Ingredient("Chicken", 4.5, false, false);
        Ingredient lettuce = new Ingredient("Lettuce", 2.5, true, false);
        Ingredient olive = new Ingredient("Olive", 2.0, true, false);

        restaurant.addIngredient(dough);
        restaurant.addIngredient(tomato);
        restaurant.addIngredient(mushroom);
        restaurant.addIngredient(cheese);
        restaurant.addIngredient(beef);
        restaurant.addIngredient(chicken);
        restaurant.addIngredient(lettuce);
        restaurant.addIngredient(olive);

        Pizza veggiePizza = new Pizza("Veggie Pizza");
        veggiePizza.addIngredient(dough);
        veggiePizza.addIngredient(tomato);
        veggiePizza.addIngredient(mushroom);
        veggiePizza.addIngredient(olive);

        Pizza cheesePizza = new Pizza("Cheese Pizza");
        cheesePizza.addIngredient(dough);
        cheesePizza.addIngredient(tomato);
        cheesePizza.addIngredient(cheese);

        Pizza meatPizza = new Pizza("Meat Pizza");
        meatPizza.addIngredient(dough);
        meatPizza.addIngredient(beef);
        meatPizza.addIngredient(cheese);

        Pizza chickenPizza = new Pizza("Chicken Pizza");
        chickenPizza.addIngredient(dough);
        chickenPizza.addIngredient(chicken);
        chickenPizza.addIngredient(tomato);

        Salad gardenSalad = new Salad("Garden Salad");
        gardenSalad.addIngredient(lettuce);
        gardenSalad.addIngredient(tomato);
        gardenSalad.addIngredient(olive);

        Salad proteinSalad = new Salad("Protein Salad");
        proteinSalad.addIngredient(lettuce);
        proteinSalad.addIngredient(chicken);
        proteinSalad.addIngredient(tomato);

        Salad simpleSalad = new Salad("Simple Salad");
        simpleSalad.addIngredient(lettuce);
        simpleSalad.addIngredient(tomato);

        restaurant.addItemToMenu(veggiePizza);
        restaurant.addItemToMenu(cheesePizza);
        restaurant.addItemToMenu(meatPizza);
        restaurant.addItemToMenu(chickenPizza);
        restaurant.addItemToMenu(gardenSalad);
        restaurant.addItemToMenu(proteinSalad);
        restaurant.addItemToMenu(simpleSalad);
    }

    private static void runMenu(Restaurant restaurant) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Restaurant Menu ===");
            System.out.println("1. View Menu");
            System.out.println("2. View Vegetarian Dishes");
            System.out.println("3. View Allergen-Free Dishes");
            System.out.println("4. Add Item to Order");
            System.out.println("5. Customize Order Item");
            System.out.println("6. Display Orders");
            System.out.println("7. Quit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewMenu(restaurant);
            } else if (choice == 2) {
                viewVegetarian(restaurant);
            } else if (choice == 3) {
                viewAllergenFree(restaurant);
            } else if (choice == 4) {
                placeOrder(restaurant);
            } else if (choice == 5) {
                customizeItem(restaurant);
            } else if (choice == 6) {
                displayOrders(restaurant);
            } else if (choice == 7) {
                running = false;
                System.out.println("Goodbye.");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewMenu(Restaurant restaurant) {
        // TODO:
        // Display each menu item with its number, name, and calculated price.
        System.out.println("Menu:");
        List<MenuItem> menu = restaurant.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.printf("%d %s %.2f\n", i + 1, item.getItemName(), item.calculatePrice());
        }
    }

    private static void viewVegetarian(Restaurant restaurant) {
        // TODO:
        // Display only vegetarian menu items.
        System.out.println("Vegetarian Menu:");
        for (MenuItem item : restaurant.getMenu()) {
            if (item.isVegetarian()) {
                System.out.printf("%s %.2f\n", item.getItemName(), item.calculatePrice());
            }
        }
    }

    private static void viewAllergenFree(Restaurant restaurant) {
        // TODO:
        // Display only allergen-free menu items.
        System.out.println("Allergen Free Menu:");
        for (MenuItem item : restaurant.getMenu()) {
            if (item.isAllergenFree()) {
                System.out.printf("%s %.2f\n", item.getItemName(), item.calculatePrice());
            }
        }
    }

    private static void placeOrder(Restaurant restaurant) {
        // TODO:
        // 1. Show the menu.
        // 2. Ask the user to choose an item number.
        // 3. Ask for an order number, 0 for new order.
        // 4. If the user enters 0, create a new order,add order to list of pendingOrders   
		// 6. Else get the order with the order number input
        // 7. Add a COPY of the selected item to the order.
		// 8. Print the order number and confirmation item was added.
		 
        viewMenu(restaurant);
        System.out.print("Enter choice:");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();

        if (itemChoice < 1 || itemChoice > restaurant.getMenu().size()) {
            System.out.println("Invalid item choice.");
            return;
        }

        System.out.print("Enter order number (0 for new order): ");
        int orderNo = scanner.nextInt();
        scanner.nextLine();

        Order order;
        if (orderNo == 0) {
            order = restaurant.createNewOrder();
            restaurant.addPendingOrder(order);
        } else {
            order = restaurant.findPendingOrder(orderNo);
        }

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        MenuItem item = restaurant.getMenu().get(itemChoice - 1).copy();
        if (order.addItemToOrder(item)) {
            System.out.println("Item added to order " + order.getOrderNo() + ".");
        } else {
            System.out.println("Item could not be added.");
        }
    }

    private static void customizeItem(Restaurant restaurant) {
        // TODO:
        // 1. Ask for an order number.
        // 2. Find the order.
        // 3. Show items in the order.
        // 4. Let the user choose one item to modify.
        // 5. Allow add/remove ingredient until the user chooses Done.
        System.out.print("Enter order number to customize: ");
        int orderNo = scanner.nextInt();
        scanner.nextLine();

        Order order = restaurant.findPendingOrder(orderNo);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        List<MenuItem> items = order.getItems();
        if (items.size() == 0) {
            System.out.println("Order has no items.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + " " + items.get(i).getItemName());
        }

        System.out.print("Enter item to customize: ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();

        if (itemChoice < 1 || itemChoice > items.size()) {
            System.out.println("Invalid item choice.");
            return;
        }

        MenuItem item = items.get(itemChoice - 1);
        System.out.println(item.getItemName());

        boolean editing = true;
        while (editing) {
            System.out.println("1. Add Ingredient");
            System.out.println("2. Remove Ingredient");
            System.out.println("3. Done");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                printIngredients(restaurant);
                System.out.print("Enter ingredient to add: ");
                String ingredientName = scanner.nextLine();
                Ingredient ingredient = restaurant.findIngredientByName(ingredientName);
                if (ingredient != null) {
                    item.addIngredient(ingredient);
                    System.out.println("Added.");
                } else {
                    System.out.println("Ingredient not found.");
                }
            } else if (choice == 2) {
                printItemIngredients(item);
                System.out.print("Enter ingredient to remove: ");
                String ingredientName = scanner.nextLine();
                if (item.removeIngredient(ingredientName)) {
                    System.out.println(ingredientName + " removed from " + item.getItemName());
                } else {
                    System.out.println(item.getItemName() + " does not contain " + ingredientName);
                }
            } else if (choice == 3) {
                editing = false;
                System.out.println("Quitting");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayOrders(Restaurant restaurant) {
        // TODO:
		// Get and sort restaurant's pending orders
        // Display all pending orders.
        Collections.sort(restaurant.getPendingOrders());
        for (Order order : restaurant.getPendingOrders()) {
            System.out.println(order);
        }
    }

    private static void printIngredients(Restaurant restaurant) {
        for (Ingredient i : restaurant.getIngredients()) {
            System.out.println("- " + i.getName());
        }
    }

    private static void printItemIngredients(MenuItem item) {
        System.out.println("Ingredients:");
        for (Ingredient i : item.getIngredients()) {
            System.out.println("- " + i.getName());
        }
    }
}
