package service;

import modell.Customer;
import repository.Database;
import view.ConsoleOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchCustomer {
    public static void searchCustomer() throws SQLException {
        // Hier Methoden zur Kundensuche einbinden
        String sqlstringquery = "SELECT * FROM Costumer_application.customer WHERE ";
        Scanner scanner = new Scanner(System.in);

        ResultSet resultSet = Database.executeQuery(sqlstringquery);

        Customer[] c = MapCustomer.mapCustomerFromDatabase(resultSet);
        for (Customer customer : c) {
            ConsoleOutput.kundenausgabe(customer);
        }
    }
}
