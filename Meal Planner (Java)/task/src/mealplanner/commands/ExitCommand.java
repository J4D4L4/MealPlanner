package mealplanner.commands;

public class ExitCommand extends Command{


    ExitCommand(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
