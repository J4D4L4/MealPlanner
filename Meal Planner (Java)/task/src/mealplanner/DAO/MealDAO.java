package mealplanner.DAO;

import mealplanner.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealDAO implements DataAccessObject<Meal>{
    static MealDAO instance;
    private static List<Meal> meals = new ArrayList<>();

    public static  MealDAO getInstance() {
        if(instance == null){
            instance = new MealDAO();
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
    public void create(Meal meal) {
        meal.setId(meals.size());
        meals.add(meal);

    }

    @Override
    public void update(Meal meal, String[] params) {

    }

    @Override
    public void delete(Meal meal) {

    }
}
