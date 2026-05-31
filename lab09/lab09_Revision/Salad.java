public class Salad extends MenuItem {
    private static final int BASE_PRICE = 15;

    public Salad(String itemName) {
        super(itemName);
    }

    public Salad(Salad other) {
        super(other);
    }

    @Override
    public double calculatePrice() {
        // TODO:
        // Start with BASE_PRICE.
        // Add the price of all ingredients.
        double total = BASE_PRICE;
        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrice();
        }
        return total;
    }

    @Override
    public boolean isValid() {
        // TODO:
        // A salad is valid only if:
        // 1. it has at least 2 ingredients
        // 2. all ingredients are vegetarian
        return ingredients.size() >= 2 && isVegetarian();
    }

    @Override
    public MenuItem copy() {
        // TODO:
        return new Salad(this);
    }
}
