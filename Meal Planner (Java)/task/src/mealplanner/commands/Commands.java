package mealplanner.commands;

import java.sql.SQLException;

public enum Commands {

    CREATEMEAL("ADD", new Object() {
        CreateMeal evaluate() {
            try {
                return new CreateMeal("Add");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate()),
    SHOWMEAL("show", new Object() {
        ShowMeals evaluate() {
            try {
                return new ShowMeals("SHOW");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate()),
    EXIT("EXIT", new Object() {
        ExitCommand evaluate() {
            try {
                return new ExitCommand("EXIT");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }.evaluate());

    public String strCommand;
    public Command command;

    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;


    }

}
