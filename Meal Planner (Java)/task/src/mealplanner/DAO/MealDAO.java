package mealplanner.DAO;

import mealplanner.DBConnector;
import mealplanner.Meal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealDAO implements DataAccessObject<Meal>{
    static MealDAO instance;
    private static List<Meal> meals = new ArrayList<>();
    static DBConnector dbConnector;

    static {
        try {
            dbConnector = new DBConnector();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MealDAO() throws SQLException {
    }

    public static  MealDAO getInstance() throws SQLException {
        if(instance == null){
            instance = new MealDAO();

            meals = dbConnector.getAllMeals();
        }
        return instance;
    }

    @Override
    public Meal get(long id) {
        return meals.get((int) id);
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public void create(Meal meal) throws SQLException {
        int mealID = dbConnector.createMeal(meal.getName(), meal.getCategory(), meal.getIngredients());
        meal.setId(mealID);
        meals.add(meal);


    }

    @Override
    public void update(Meal meal, String[] params) {

    }

    @Override
    public void delete(Meal meal) {

    }
}
