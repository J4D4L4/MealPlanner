package mealplanner;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {

    CommandLineInterface cli = new CommandLineInterface();
    DBConnector.initalieDB();
    cli.run();
  }
}