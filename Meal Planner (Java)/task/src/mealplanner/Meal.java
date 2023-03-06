package mealplanner;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    MealCategory category;
    String name;
    List<String> ingredients;

    public Meal(MealCategory category, String name){
        this.category = category;
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public void printMeal(){
        System.out.printf("Category: %s%n", this.category.name());
        System.out.printf("Name: %s%n",this.name);
        System.out.printf("Ingredients: %n");
        for (String ingridient : ingredients){
            System.out.println(ingridient);
        }
    }

    public MealCategory getCategory() {
        return category;
    }

    public void setCategory(MealCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
