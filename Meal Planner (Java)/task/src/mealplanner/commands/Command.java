package mealplanner.commands;

import mealplanner.DAO.MealDAO;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class Command {

    String inputString;
    MealDAO mealDAO;


    protected Command(String inputString) throws SQLException {
        this.inputString = inputString;
        this.mealDAO = MealDAO.getInstance();

    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



    public abstract void execute() throws SQLException;


}