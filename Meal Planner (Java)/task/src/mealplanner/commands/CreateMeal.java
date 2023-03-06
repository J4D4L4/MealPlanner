package mealplanner.commands;

import mealplanner.Meal;
import mealplanner.MealCategory;

import java.util.Arrays;
import java.util.List;

public class CreateMeal extends Command{
    public CreateMeal(String inputString) {
        super(inputString);
    }

    @Override
    public void execute() {
        createMeal();

    }

    public Meal createMeal(){
        MealCategory category = getCategory();
        String name = getMealName();
        Meal newMeal = new Meal(category,name);
        newMeal.setIngredients(getIngridients());
        newMeal.printMeal();
        System.out.println("The meal has been added!");
        return newMeal;


    }

    MealCategory getCategory(){
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        String input = getUserInput();
        switch (input.toUpperCase()){
            case "BREAKFAST":
                return MealCategory.BREAKFAST;
            case "LUNCH":
                return MealCategory.LUNCH;
            case "DINNER":
                return MealCategory.DINNER;
            default:
                return MealCategory.ERROR;
        }
    }

    String getMealName(){
        System.out.println("Input the meal's name:");
        return getUserInput();
    }

    List<String> getIngridients(){
        System.out.println("Input the ingredients:");
        String[] inputIngridients = getUserInput().split(",");
        List<String> ingridientList = Arrays.stream(inputIngridients).toList();
        return ingridientList;
    }

}
