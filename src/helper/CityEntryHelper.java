package helper;

import data.City;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    /*
     * This is the actual SQL query that will send the data from our Java program to the
     * SQL database.
     * The `?` here is called a parameter.
     * This is just a placeholder for the actual value in the SQL query.
     * Using the `?`, we can define the actual value later on when we are ready to execute the query.
     * */
    private static final String CREATE_CITY_QUERY =
            "INSERT INTO " + TABLE_NAME + " (name, traversed, kilometers_required) VALUES (?, ?, ?);";

    // This SQL query will fetch all the records (entries) from the cities table.
    private static final String READ_ALL_CITIES_QUERY =
            "SELECT * FROM " + TABLE_NAME + ";";

    /**
     * This method will create an entry for a new city in the cities table of the database;
     *
     * @param connection The reference of the current connection to the database.
     * @param city       The values of the city we want to add, wrapped in a City object.
     */
    public boolean createANewCityInTheDatabase(Connection connection, City city) {
        boolean isSuccess = false;
        try {
            PreparedStatement createCityStatement = connection.prepareStatement(CREATE_CITY_QUERY);
            createCityStatement.setString(1, city.getCityName());
            createCityStatement.setBoolean(2, city.isCityTraversed());
            createCityStatement.setInt(3, city.getKilometersRequired());
            createCityStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                    null,
                    "Sorry, we could not add the city \"" + city.getCityName() + "\" to the database." +
                            "\n" + exception.getMessage(),
                    "ERROR 2",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return isSuccess;
    }

    /**
     * This method will read all the entries from the cities table and print it
     * for the user.
     *
     * @param connection The reference of the current connection to the database.
     */
    public void printAllCitiesInDatabase(Connection connection) {
        try {
            PreparedStatement readAllCitiesStatement =
                    connection.prepareStatement(READ_ALL_CITIES_QUERY);
            ResultSet resultSet = readAllCitiesStatement.executeQuery();
            StringBuilder builder = new StringBuilder();
            while (resultSet.next()) {
                String cityName = resultSet.getString(NAME_COLUMN);
                boolean isTraversed = resultSet.getBoolean(TRAVERSED_COLUMN);
                int kmsRequired = resultSet.getInt(KMS_REQUIRED_COLUMN);
                City city = new City(cityName, isTraversed, kmsRequired);
                builder.append(city.toString()).append("\n").append("-".repeat(150)).append("\n");
            }
            JTextArea textArea = new JTextArea(builder.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            scrollPane.setPreferredSize(new Dimension(1024, 400));
            JOptionPane.showMessageDialog(
                    null,
                    scrollPane,
                    "Cities In The Database",
                    JOptionPane.PLAIN_MESSAGE
            );
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                    null,
                    "Sorry, could not read the values from the database.",
                    "ERROR 3",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
