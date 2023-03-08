Meal Planner

Stage 1 Add Meals:
To complete this stage, your program should:

- Ask about the meal category with the following message: Which meal do you want to add (breakfast, lunch, dinner)?;
- Ask about the name of the meal with the message Input the meal's name:;
- Inquire about the necessary ingredients with the message Input the ingredients:. The input contains ingredients in one line separated by commas. The output displays each ingredient on a new line (see Examples);
- Print all the information about the meal in the following format:

Stage 2 Create a Menu:
- Create an infinite loop of your program that can be terminated with the exit command only;
- Prompt users to choose an operation with the message What would you like to do (add, show, exit)?
- After the command has been processed, ask for another operation;
- Make sure that the input and output formats are correct;
- If users want to add a meal, follow the sequence from the previous stage. Don't forget to validate input as explained above. Output The meal has been added! before proceeding;
- If users want to show the meals when no meals have been added, print No meals saved. Add a meal first. If there are meals that can be dislayed, print them in the order they've been added, following the format from Stage 1;
- Print Bye! and end the program once the exit command is entered;
- If users fail to input a valid command, print the following message again: What would you like to do (add, show, exit)?
Stage 3 Database storage:
- Your program should connect to a database named meals_db;
-  Create two tables in this database schema. Name the first one as meals with three columns: category (varchar), meal (varchar), and meal_id (integer). Name the second table ingredients; it must contain three columns: ingredient (varchar), ingredient_id (integer), and meal_id (integer). meal_id in both tables must match!
-  Read all data in the tables, so their contents are available before a show operation is requested;
-  When users add a new meal, store it in your database.