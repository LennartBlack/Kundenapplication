package database;

import com.mysql.cj.xdevapi.PreparableStatement;
import modell.Customer;
import view.ConsoleOutput;

import java.sql.*;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/costumer_application";
    private static final String USER = "user_2";
    private static final String PASSWORD = "1234";
    private Connection connection;


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

    /**
     *
     * @param sqlQuery Muss eine korrekte SQL-Query in Form eines String
     * @return In case the query succeeded method returns a ResulSet. In case the query failed return is null.
     * @throws SQLException
     */
    public ResultSet executeQuery(String sqlQuery){
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery);
            return preparedStatement.executeQuery();
        }
        catch (SQLException sqlException){
            ConsoleOutput.printString(sqlException.toString());
        }
        return null;
    }

    /*
    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
     */
    public int insertStatement(String insertQuery) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet generatedId = preparedStatement.getGeneratedKeys();
            if(generatedId.next()){
                return generatedId.getInt(1);
            }
        }
        catch (SQLException sqlException){
            ConsoleOutput.printString(sqlException.toString());
        }
        return -1;
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public Connection getConnection() {
        return this.connection;
    }


}
