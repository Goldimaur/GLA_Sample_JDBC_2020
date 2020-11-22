package main;

import connection.DatabaseConnection;
import data.City;
import helper.CityEntryHelper;

import javax.swing.*;

public class Main {

    public static final int CREATE_NEW_CITY = 1;
    public static final int PRINT_ALL_CITIES = 2;
    public static final int MODIFY_CITY = 3;
    public static final int DELETE_CITY = 4;
    public static final int EXIT = 5;

    private static CityEntryHelper helper = null;

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        // attempting to connect to a database
        databaseConnection.connectToDatabase();
        helper = new CityEntryHelper();
        int choice = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                """
                        Enter 1 to add a new city into the database.
                        Enter 2 to view all the cities currently in the database.
                        Enter 3 to modify a particular city in the database.
                        Enter 4 to delete a particular city from the database.
                        Enter 5 to exit.""",
                "GLA JDBC GAME MENU",
                JOptionPane.PLAIN_MESSAGE
        ));
        switch (choice) {
            case CREATE_NEW_CITY -> {
                helper.createANewCityInTheDatabase(
                        DatabaseConnection.getConnection(),
                        createNewCity()
                );
                JOptionPane.showMessageDialog(
                        null,
                        "City Added To The Database",
                        "SUCCESSFULL",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            case PRINT_ALL_CITIES -> printAllCities();
            case MODIFY_CITY -> {
                modifyCity();
            }
            case DELETE_CITY -> deleteCity();
            case EXIT -> System.exit(0);
        }
    }

    private static void deleteCity() {

    }

    private static void modifyCity() {
        helper.modifyCityInDatabase(
                DatabaseConnection.getConnection(),
                inputCityName(),
                inputCityKilometers()
        );
    }

    private static void printAllCities() {
        helper.printAllCitiesInDatabase(DatabaseConnection.getConnection());
    }

    private static City createNewCity() {
        /*
         * To add an entry for a new city into the cities table in the database,
         * we need to do the following:
         * 1. Ask the user to input all the values of the attributes of a City-type.
         * 2. Collect all the values together into a city object.
         * 3. Send the city object to the `createANewCityInTheDatabase()` method
         * of the `CityEntryHelper.java` class.
         * */
        String cityName = inputCityName();
        boolean isCityTraversed = inputCityTraversed(cityName);
        int kmsRequired = inputCityKilometers();
        return new City(cityName, isCityTraversed, kmsRequired);
    }

    private static int inputCityKilometers() {
        return Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Please enter the kilometers required value.",
                "Enter Kilometers Required",
                JOptionPane.PLAIN_MESSAGE
        ));
    }

    private static boolean inputCityTraversed(String cityName) {
        return Boolean.parseBoolean(JOptionPane.showInputDialog(
                null,
                "Have you ever been to " + cityName + " ?",
                "Enter Visited Status",
                JOptionPane.PLAIN_MESSAGE
        ));
    }

    private static String inputCityName() {
        return JOptionPane.showInputDialog(
                null,
                "Please enter the name of the new city.",
                "Enter City Name",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
