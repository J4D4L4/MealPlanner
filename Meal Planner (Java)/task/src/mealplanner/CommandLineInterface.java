package mealplanner;

import mealplanner.commands.CreateMeal;

public class CommandLineInterface {
    public void run()  {
        CreateMeal createMeal = new CreateMeal("CM");
        createMeal.execute();

    }
}
