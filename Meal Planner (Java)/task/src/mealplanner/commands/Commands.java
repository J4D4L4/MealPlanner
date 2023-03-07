package mealplanner.commands;

public enum Commands {

    CREATEMEAL("ADD", new CreateMeal("Add")),
    SHOWMEAL("show", new ShowMeals("SHOW")),
    EXIT("EXIT", new ExitCommand("EXIT"));

    public String strCommand;
    public Command command;

    Commands(String strCommand, Command classCommand){
        this.strCommand =strCommand;
        this.command = classCommand;


    }

}
