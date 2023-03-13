package mealplanner.commands;

import mealplanner.Meal;
import mealplanner.MealCategory;
import mealplanner.RegExHelper;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateMeal extends Command{
    public CreateMeal(String inputString) throws SQLException {
        super(inputString);
    }

    @Override
    public void execute() throws SQLException {
        createMeal();

    }

    public Meal createMeal() throws SQLException {
        MealCategory category = getCategory();
        String name = getMealName();
        List<String> ingridients = getIngridients();
        Meal newMeal = new Meal(category,name,ingridients);
        System.out.println("The meal has been added!");
        mealDAO.create(newMeal);
        return newMeal;


    }

    MealCategory getCategory(){
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        while (true) {
            String input = getUserInput();
            switch (input.toUpperCase()) {
                case "BREAKFAST":
                    return MealCategory.BREAKFAST;
                case "LUNCH":
                    return MealCategory.LUNCH;
                case "DINNER":
                    return MealCategory.DINNER;
                default:
                    System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
                    break;
            }
        }
    }

    String getMealName(){
        System.out.println("Input the meal's name:");
        String name = getUserInput();
        while (!RegExHelper.mealNamevalidation(name)){
            System.out.println("Wrong format. Use letters only!");
            name = getUserInput();
        }
        return name;
    }

    List<String> getIngridients(){
        System.out.println("Input the ingredients:");
        String[] input = getUserInput().split(",");
        while(!checkInputs(input)){
            System.out.println("Wrong format. Use letters only!");

            input = getUserInput().replace(" ","xyz").replace(",",", ").split(",");
            input = Arrays.stream(input).map(inString -> inString.replace(" ", "").replace("xyz"," ")).collect(Collectors.toList()).toArray(new String[0]);
        }
        List<String> ingridientList = Arrays.stream(input).toList();
        return ingridientList;
    }

    boolean checkInputs(String[] ingridients){

        for (String ingridient : ingridients){
            ingridient = ingridient.replace(" ","");
            if (!RegExHelper.mealNamevalidation(ingridient)){

                return false;
            }

        }
        return true;

    }



}
