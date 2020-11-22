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

    /*
     * This is the name of the table in our database.
     * It has three attributes:
     * 1. name: to store the name of the city.
     * 2. traversed: to store whether the city is visited.
     * 3. kilometers_required: to store how many kilometers the user need to visit this city.
     * */
    private static final String TABLE_NAME = "cities";

    private static final String NAME_COLUMN = "name";
    private static final String TRAVERSED_COLUMN = "traversed";
    private static final String KMS_REQUIRED_COLUMN = "kilometers_required";

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
