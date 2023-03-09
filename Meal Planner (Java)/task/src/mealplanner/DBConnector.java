package mealplanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class DBConnector {

    static String DB_URL = "jdbc:postgresql://localhost/meals_db";
    static String USER = "mealuser";
    static String PASS = "1111";
    IDGenerator idGenerator = IDGenerator.getInstance();

    public DBConnector() throws SQLException {
    }


    public static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        connection.setAutoCommit(true);
        return connection;
    }

    public int createMeal(String mealName, MealCategory categoryIn, List<String> ingridients) throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        int mealId = idGenerator.getNextId();
        String sqlStatement = "insert into meals (category, meal, meal_id) values (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        ps.setString(1, categoryIn.name());
        ps.setString(2, mealName);
        ps.setInt(3,mealId);
        //statement.executeUpdate(sqlStatement);
        ps.executeUpdate();
        statement.close();
        connection.close();
        for(String ingridient : ingridients){
            createIngridient(ingridient,mealId);
        }
        return mealId;


    }

    void createIngridient(String ingridient,  int meal_id) throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        int ingridientId = idGenerator.getNextId();
        String sqlStatement = "insert into ingredients (ingredient, ingredient_id, meal_id) values (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        ps.setString(1, ingridient);
        ps.setInt(2, idGenerator.getNextId());
        ps.setInt(3,meal_id);
        ps.executeUpdate();
        statement.close();
        connection.close();
    }

    static int getMaxID() throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        String sql = "select max(ingredient_id) from ingredients";
        ResultSet rs = statement.executeQuery(sql);
        int returnId=0;
        if(rs.next()){
            returnId = rs.getInt(1);
            int maxMealID = getMaxMealId();
            if(returnId<maxMealID)
                returnId = maxMealID;
        }
        else
            returnId = getMaxMealId();
        statement.close();
        connection.close();
        return returnId;
    }

    static int getMaxMealId() throws SQLException {
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        String sql = "select max(meal_id) from meals";
        ResultSet rs = statement.executeQuery(sql);
        int returnId=0;
        if(rs.next()){
            returnId = rs.getInt(1);
        }

        statement.close();
        connection.close();
        return returnId;

    }
    public static List<Meal> getAllMeals() throws SQLException {
        List<Meal> mealList = new ArrayList<>();
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        String sql = "select * from meals";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Meal nextMeal = createMealFromResult(rs);
            mealList.add(nextMeal);
        }

        return mealList;
    }

    public static List<String> getIngredientsForMealId(int mealId) throws SQLException {

        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        String sqlStatement = "select * from ingredients where meal_id = ?";
        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        ps.setInt(1, mealId);
        ResultSet resultSet = ps.executeQuery();
        List<String> ingredients = new ArrayList<>();
        while(resultSet.next()){
            ingredients.add(resultSet.getString(1));
        }
        return ingredients;

    }
    private static Meal createMealFromResult(ResultSet resultSet) throws SQLException {
        MealCategory mealCategory = Meal.getMealCategoryFromInput(resultSet.getString(1));
        String meal = resultSet.getString(2);
        int mealID = resultSet.getInt(3);
        List<String> ingredients = getIngredientsForMealId(mealID);
        Meal returnMeal = new Meal(mealCategory,meal,ingredients);
        returnMeal.setId(mealID);
        return returnMeal;


    }




}
