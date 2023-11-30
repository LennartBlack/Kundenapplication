package Database;

import java.sql.*;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/costumer_application";
    private static final String USER = "user_2";
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

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC-Treiber nicht gefunden!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank fehlgeschlagen!");
            e.printStackTrace();
        }
    }
    public ResultSet query(String sqlQuery) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        return preparedStatement.executeQuery();
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
