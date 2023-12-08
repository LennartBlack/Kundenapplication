package repository;

import view.ConsoleOutput;
import java.sql.*;
import java.util.Optional;


public class Database {
    //Attributes
    private static final String URL = "jdbc:mysql://localhost:3306/costumer_application";
    private static final String USER = "user_2";
    private static final String PASSWORD = "1234";

    //Contructor
    public Database(){
    }

    //Methods
    /**
     *
     * @param sqlQuery Muss eine korrekte SQL-Query in Form eines String
     * @return In case the query succeeded method returns a ResulSet. In case the query failed return is null.
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sqlQuery){
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery);
            return preparedStatement.executeQuery();
        }
        catch (SQLException sqlException){
            ConsoleOutput.printString(sqlException.toString());
        }
        return null;
    }

    /** Method to delete or update a customer
     *
     * @param sqlQuery Delete-Query
     * @return affected rows if successfull. Otherwise -1.
     */
    public static int executeUpdate(String sqlQuery){
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeUpdate(sqlQuery);
        }
        catch (SQLException sqlException){
            ConsoleOutput.printString(sqlException.toString());
        }
        catch(NullPointerException nullPointerException){
            System.out.println("Verbindung zur Datenbank fehlgeschlagen.");
        }
        return -1;
    }

    /**
     *
     * @param insertQuery Insert SQL- Statement in Textform.
     * @return Die von der Datenbank generierte ID
     */
    public static Optional<Integer> insertStatement(String insertQuery) throws SQLException {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet generatedId = preparedStatement.getGeneratedKeys();
            if(generatedId.next()){
                return Optional.of(generatedId.getInt(1));
            }

            getConnection().close();
        }
        catch (SQLException sqlException){
            System.out.println("Die Datenbank blockiert die Eingabe.");
        }
        catch (NullPointerException nullPointerException){
            System.out.println("Kritischer Fehler.");

        }

        return Optional.empty();
    }

    public static Connection getConnection() {
        try {
            // TODO für später: Verbindung erst bei Datenbankaufruf herstellen und dann auch wieder schließen
            // Registriere den MySQL JDBC-Treiber
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Baue die Verbindung zur Datenbank auf
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Erfolgreich mit der Datenbank verbunden.");

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Der Softwaretreiber wurde nicht gefunden.");
        } catch (SQLException e) {
            System.out.println("Die Verbindung zur Datenbank ist fehlgeschlagen.");
        }
        return null;
    }
}
