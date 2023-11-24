package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public Database() throws SQLException, ClassNotFoundException {
        try {
            // Registriere den MySQL JDBC-Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Baue die Verbindung zur Datenbank auf
            Connection connection = DriverManager.getConnection(url, user, password);

            // Überprüfe, ob die Verbindung erfolgreich war
            if (connection != null) {
                System.out.println("Erfolgreich mit der Datenbank verbunden!");
                // Hier kannst du weitere Aktionen mit der Datenbank durchführen
                // ...

                // Schließe die Verbindung, wenn sie nicht mehr benötigt wird
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC-Treiber nicht gefunden!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank fehlgeschlagen!");
            e.printStackTrace();
        }
    }
    // JDBC-URL, Benutzername und Passwort der MySQL-Datenbank
    private String url = "jdbc:mysql://localhost:3306/kundenliste";
    private String user = "user_1";
    private String password = "1234";
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
