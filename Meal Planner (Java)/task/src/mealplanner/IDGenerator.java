package mealplanner;

import java.sql.SQLException;

public class IDGenerator {

    static IDGenerator instance;
    int id=DBConnector.getMaxID()+1;

    public IDGenerator() throws SQLException {
    }

    static IDGenerator getInstance() throws SQLException {

        if(instance == null){
            instance = new IDGenerator();

        }

        return instance;

    }

    int getNextId(){
        int nextID = id;
        id++;
        return nextID;
    }

}
