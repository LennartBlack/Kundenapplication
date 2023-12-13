package service;

import modell.Customer;
import repository.Database;
import view.ConsoleOutput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchCustomer {

    //Constructor
    private SearchCustomer(){}

    //Methods
    public static ResultSet searchCustomer() throws SQLException {
        // Hier Methoden zur Kundensuche einbinden
        String sqlstringquerypreset = "SELECT * FROM Costumer_application.customer WHERE ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Über welche Eigenschaft möchten Sie einen Kunden Suchen?.");
        System.out.println("<< 1 >> für Kundennummer");
        System.out.println("<< 2 >> für Namen");
        System.out.println("<< 3 >> für Adresse");

        int userInput = scanner.nextInt();
        while(userInput<1 && userInput >3){
            System.out.println("Fehlerhafte Eingabe.");

            System.out.println("Über welche Eigenschaft möchten Sie einen Kunden Suchen?.");
            System.out.println("<< 1 >> für Kundennummer");
            System.out.println("<< 2 >> für Namen");
            System.out.println("<< 3 >> für Adresse");
            userInput = scanner.nextInt();
        }

        String sqlqueryclaus = "";
        switch (userInput){
            case 1 ->{
                System.out.println("Geben Sie die Kundennummer ein, nach de gesucht werden soll.");
                int kundennummersuche = scanner.nextInt();
                sqlqueryclaus = "customer_number = " + kundennummersuche + ";";
            }
            case  2 ->{
                System.out.println("Geben Sie den Vornamen des Kunden ein.");
                String name = scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Geben Sie den Nachnamen des Kunden ein.");
                String familyName = scanner.nextLine();
                sqlqueryclaus = "name = '" + name + "' AND family_name = '" + familyName + "';";
            }
            case 3 ->{
                System.out.println("Geben Sie die Straße des Kunden ein");
                String street = scanner.nextLine();
                System.out.println("Geben Sie die Hausnummer ein");
                String houseNumber = scanner.nextLine();
                System.out.println("Geben Sie die Postleitzahl ein");
                String postcode = scanner.nextLine();
                System.out.println("Geben Sie die Stadt ein");
                String city = scanner.nextLine();

                sqlqueryclaus = "street = " + street + " AND" + " house_number = " + houseNumber + " AND postcode = " + postcode
                        + " AND city = " + city + ";";
            }
        }

        String sqlQuery = sqlstringquerypreset + sqlqueryclaus;
        System.out.println(sqlQuery);
        return Database.executeQuery(sqlQuery);
    }
}
