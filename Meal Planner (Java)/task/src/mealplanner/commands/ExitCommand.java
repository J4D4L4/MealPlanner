package mealplanner.commands;

import java.sql.SQLException;

public class ExitCommand extends Command{


    ExitCommand(String inputCommand) throws SQLException {
        super(inputCommand);
    }

    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
