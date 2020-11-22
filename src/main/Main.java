package main;

import connection.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        // attempting to connect to a database
        databaseConnection.connectToDatabase();
    }
}
