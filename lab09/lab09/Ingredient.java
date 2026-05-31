public class Ingredient {
    private String ingredientName;
    private double price;
    private int stockCount;
    private boolean isVeg;
    private boolean isAllergen;

    public Ingredient(String name, double price, boolean vegetarian, boolean allergen) {
        this.ingredientName = name;
        this.price = price;
        this.isVeg = vegetarian;
        this.isAllergen = allergen;
        this.stockCount = 0;
    }

    public String getName() {
        return ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public boolean isVegetarian() {
        return isVeg;
    }

    public boolean isAllergen() {
        return isAllergen;
    }

    public boolean consume(int quantity) {
        if (quantity <= 0) {
            return false;
        }
        if (stockCount < quantity) {
            return false;
        }
        stockCount -= quantity;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient) {
            Ingredient other = (Ingredient) obj;
            return ingredientName.equalsIgnoreCase(other.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f c, stock: %d)", ingredientName, price, stockCount);
    }
}