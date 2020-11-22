package connection;

import java.sql.Connection;

/**
 * This class will create a new connection to the database.
 * <br>
 * This class is extremely important for JDBC implementation.
 * <br>
 */
public class DatabaseConnection {

    /**
     * This String constant contains the URL to the database on our localhost server
     * provided by XAMPP.
     * <br>
     * I would just like to take a minute to point out that using XAMPP is not at all
     * extremely mandatory, nor is it the only server emulator out there. We have
     * XAMPP, WAMP, MAMP, and many more.
     * <br>
     * XAMPP is just the only I believe is most easy-to-install and configure for a
     * beginner.
     * <br>
     * Also, when working in a real-world environment, or as we developers like to call it
     * 'a production environment', your actual database might be hosted on a live-server.
     * You can still use the same code to connect to it, by just changing the URL and other
     * parameters for the database accordingly.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/google_play_game";

    /**
     * This is the username of the admin of the database.
     * Usually, on server emulators like XAMPP, it is defaulted to 'root'.
     */
    private static final String USERNAME = "root";

    /**
     * This is the password of the admin of the database.
     * If you are using XAMPP like me, then the default password is just going to be blank.
     * IF you are using another emulator like WAMP or MAMP, then you need to consult your
     * configuration or the documentation provided by the software vendor for the password.
     */
    private static final String password = "";

    /**
     * This connection variable is required to maintain
     * the reference of a connection to the actual database.
     */
    private static final Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }
}
