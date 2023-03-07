package mealplanner;

import mealplanner.commands.Command;
import mealplanner.commands.Commands;
import mealplanner.commands.CreateMeal;

import java.util.Scanner;

public class CommandLineInterface {
    public void run()  {
        while (true) {
            printMenu();
            String input = getUserInput();
            interpretInput(input);
        }

    }

    public void printMenu(){
        System.out.println("What would you like to do (add, show, exit)?");
    }

    public void interpretInput(String input){

        for(Commands command : Commands.values()){
            if(command.strCommand.toUpperCase().equals(input.toUpperCase())){
                command.command.execute();
            }
        }

    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
