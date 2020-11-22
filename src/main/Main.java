package main;

import connection.DatabaseConnection;

import javax.swing.*;

public class Main {
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
            case 1 -> createNewCity();
            case 2 -> printAllCities();
            case 3 -> modifyCity();
            case 4 -> deleteCity();
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
