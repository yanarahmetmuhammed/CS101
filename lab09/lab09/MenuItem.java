import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MenuItem {
    protected String itemName;
    protected ArrayList<Ingredient> ingredients;

    public MenuItem(String itemName) {
        this.itemName = itemName;
        this.ingredients = new ArrayList<>();
    }

    protected MenuItem(MenuItem other) {
        this.itemName = other.itemName;
        this.ingredients = new ArrayList<>();

        for (Ingredient i : other.ingredients) {
            this.ingredients.add(i);
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public boolean removeIngredient(String ingredientName) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getName().equalsIgnoreCase(ingredientName)) {
                ingredients.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean containsIngredientByName(String ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                return true;
            }
        }
        return false;
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public boolean isVegetarian() {
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isVegetarian()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllergenFree() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isAllergen()) {
                return false;
            }
        }
        return true;
    }
	public String toString(){
		return itemName + " ";
	}
    public abstract double calculatePrice();

    public abstract boolean isValid();

    public abstract MenuItem copy();
}