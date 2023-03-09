package mealplanner.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T> {

    T get(long id);
    List<T> getAll();
    void create(T t) throws SQLException;
    void update(T t, String[] params);
    void delete(T t);

}
