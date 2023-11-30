package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/kundenliste";
    private static final String USER = "user_1";
    private static final String PASSWORD = "1234";
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }

    public Database() throws SQLException, ClassNotFoundException {
        try {
            // Registriere den MySQL JDBC-Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Baue die Verbindung zur Datenbank auf
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Erfolgreich mit der Datenbank verbunden!");
            // Hier kannst du weitere Aktionen mit der Datenbank durchführen
            // ...

            // Schließe die Verbindung, wenn sie nicht mehr benötigt wird
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC-Treiber nicht gefunden!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank fehlgeschlagen!");
            e.printStackTrace();
        }
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
