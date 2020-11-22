package helper;

import data.City;

import java.sql.Connection;

/**
 * This class will help us utilize the City.java data class.
 * <br>
 * This class will define helper methods for us to perform basic
 * CRUD operations on the database.
 * <br>
 * We will create a method to:
 * 1. Add a new entry of a City to the cities table in the database.
 * 2. View all the cities that are present in the cities table in the database.
 * 3. Modify the entry of a particular city in the cities table of the database.
 * 4. Delete the entry of a particular city from the cities table of the database.
 */
public class CityEntryHelper {

    /**
     * This method will create an entry for a new city in the cities table of the database;
     *
     * @param connection The reference of the current connection to the database.
     * @param city       The values of the city we want to add, wrapped in a City object.
     */
    public boolean createANewCityInTheDatabase(Connection connection, City city) {
        boolean isSuccess = false;
        return isSuccess;
    }

}
