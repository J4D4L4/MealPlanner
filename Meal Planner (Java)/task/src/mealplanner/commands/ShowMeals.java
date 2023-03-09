package mealplanner.commands;

import mealplanner.Meal;

import java.sql.SQLException;
import java.util.List;

public class ShowMeals extends Command{
    protected ShowMeals(String inputString) throws SQLException {
        super(inputString);
    }

    @Override
    public void execute() {
        List<Meal> meals = mealDAO.getAll();
        if(meals.size()>0) {
            for (Meal meal : meals) {
                meal.printMeal();
            }
        }
        else System.out.println("No meals saved. Add a meal first.");
    }
}
