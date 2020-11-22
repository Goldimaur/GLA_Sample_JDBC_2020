package main;

import connection.DatabaseConnection;

import javax.swing.*;

public class Main {

    public static final int CREATE_NEW_CITY = 1;
    public static final int PRINT_ALL_CITIES = 2;
    public static final int MODIFY_CITY = 3;
    public static final int DELETE_CITY = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        // attempting to connect to a database
        databaseConnection.connectToDatabase();
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
            case CREATE_NEW_CITY -> createNewCity();
            case PRINT_ALL_CITIES -> printAllCities();
            case MODIFY_CITY -> modifyCity();
            case DELETE_CITY -> deleteCity();
            case EXIT -> System.exit(0);
        }
    }

    private static void deleteCity() {

    }

    private static void modifyCity() {

    }

    private static void printAllCities() {

    }

    private static void createNewCity() {
    }
}
