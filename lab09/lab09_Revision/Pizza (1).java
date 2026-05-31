public class Pizza extends MenuItem {
    private static final int BASE_PRICE = 30;

    public Pizza(String itemName) {
        super(itemName);
    }

    public Pizza(Pizza other) {
        super(other);
    }

    @Override
    public double calculatePrice() {
        // TODO:
        // Start with BASE_PRICE.
        // Add the price of each ingredient except dough.
        double total = BASE_PRICE;
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.getName().equalsIgnoreCase("Dough")) {
                total += ingredient.getPrice();
            }
        }
        return total;
    }

    @Override
    public boolean isValid() {
        // TODO:
        // A pizza is valid only if:
        // 1. it contains dough
        // 2. it has at least 2 ingredients
        return containsIngredientByName("Dough") && ingredients.size() >= 2;
    }

    @Override
    public boolean removeIngredient(String ingredientName) {
        // TODO:
        // Dough may not be removed from a pizza.
        // Otherwise use the inherited behavior.
		//return true if ingredient removed, false if not
        if (ingredientName.equalsIgnoreCase("Dough")) {
            return false;
        }
        return super.removeIngredient(ingredientName);
    }

    @Override
    public MenuItem copy() {
        // TODO:
		//return a copy of the Pizza 
		//do not duplicate code
        return new Pizza(this);
    }
}
