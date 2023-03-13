package mealplanner.commands;

import mealplanner.DAO.MealDAO;
import mealplanner.Meal;
import mealplanner.MealCategory;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class ShowMeals extends Command{
    MealDAO mealDAO = MealDAO.getInstance();
    protected ShowMeals(String inputString) throws SQLException {
        super(inputString);
    }

    @Override
    public void execute() {
        System.out.println("Which category do you want to print (breakfast, lunch, dinner)?");
        getCategoryMeals();


    }

    public void getCategoryMeals(){
        String input = getUserInput();
        MealCategory category = Meal.getMealCategoryFromInput(input);
        while (category == MealCategory.ERROR){
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            input = getUserInput();
            category = Meal.getMealCategoryFromInput(input);

        }


        printMealList(mealDAO.getWithCategory(category));

    }

    public void printMealList(List<Meal> meals){
        if(meals.size()>0) {
            System.out.printf("Category: %s%n", meals.get(0).getCategory().name().toLowerCase());
            for (Meal meal : meals) {

                meal.printMeal();
                System.out.println("");
            }
        }
        else System.out.println("No meals found.");
    }
}
