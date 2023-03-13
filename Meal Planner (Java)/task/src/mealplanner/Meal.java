package mealplanner;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    int id;
    MealCategory category;
    String name;
    List<String> ingredients;

    public Meal(MealCategory category, String name){

        this.category = category;
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public Meal(MealCategory category, String name, List<String> ingredients){

        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
    }

    public void printMeal(){

        System.out.printf("Name: %s%n",this.name);
        System.out.printf("Ingredients:%n");
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
    public void setId(long íd){
        this.id = id;
    }

    public static MealCategory getMealCategoryFromInput(String input){
        switch (input.toUpperCase()) {
            case "BREAKFAST":
                return MealCategory.BREAKFAST;
            case "LUNCH":
                return MealCategory.LUNCH;
            case "DINNER":
                return MealCategory.DINNER;
            default:
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
                return MealCategory.ERROR;

        }
    }

}
