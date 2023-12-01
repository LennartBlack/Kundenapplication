package controller;

import database.Database;
import modell.Customer;
import service.MapCustomerOperations;
import view.ConsoleOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class Controller {
    private Database database;
    ConsoleOutput consoleOutput;
    private String query;
    private Scanner scanner;
    private int benutzereingabe;
    private MapCustomerOperations queryConvert;
    public Controller(Database db) throws SQLException, ClassNotFoundException {
        this.database = db;
        this.consoleOutput = new ConsoleOutput(db);
    }
    public void determineNextAction() throws SQLException {
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
        this.scanner = new Scanner(System.in);
        System.out.println("1 für Kunden suchen");
        System.out.println("2 für Kunden updaten");
        System.out.println("3 für Kunden löschen");
        System.out.println("4 für Kunden anlegen");
        System.out.println("5 Anwendung beenden");
        this.benutzereingabe = scanner.nextInt();
        switch (benutzereingabe) {
            case 1 -> {
                String sqlstringquery = "SELECT * FROM Costumer_application.costumer WHERE name='Saskia'";
                ResultSet resultSet = database.query(sqlstringquery);
                Customer[] c = MapCustomerOperations.mapCustomerFromDatabase(resultSet);
                for (Customer customer : c) {
                    ConsoleOutput.kundenausgabe(customer);
                }
                // Hier Methoden zur Kundensuche einbinden
                System.out.println("Die Möglichkeit zur Kundensuche ist noch nicht implementiert.");
                determineNextAction();
            }
            case 2 -> {
                // Hier Methoden zur Kundenänderung einbinden
                System.out.println("Die Möglichkeit zur Kundenänderung ist noch nicht implementiert.");
                determineNextAction();
            }
            case 3 -> {
                // Hier Methoden zur Kundenlöschung einbinden
                System.out.println("Die Möglichkeit zur Kundenlöschung ist noch nicht implementiert.");
                determineNextAction();
            }
            case 4 -> {
                createCustomer();
                System.out.println("Die Möglichkeit zur Kundenanlegung ist noch nicht implementiert.");
                determineNextAction();
            }
            case 5 -> {
                System.out.println("Die Anwendung wird beendet.");
                database.closeConnection();
            }
            default -> {}
        }
        scanner.close();
    }
    public static void createCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer c = new Customer();

        // Gender
        System.out.println("Gender?");
        System.out.println("1 für Herr");
        System.out.println("2 für Frau");
        System.out.println("3 für Divers");
        int gender = scanner.nextInt();
        switch (gender) {
            case 1 -> c.setGender("Herr");
            case 2 -> c.setGender("Frau");
            case 3 -> c.setGender("Divers");
            default -> c.setGender(null);
        }

        // Titel
        System.out.println("Titel?");
        System.out.println("1 für Dr.");
        System.out.println("2 für Prof.");
        int titel = scanner.nextInt();
        switch (titel) {
            case 1 -> c.setTitle("Dr.");
            case 2 -> c.setTitle("Prof.");
            default -> c.setTitle(null);
        }
        // Name
        System.out.println("Vorname?");
        c.setName(scanner.nextLine());

        // Family name
        System.out.println("Nachname?");
        c.setFamilyName(scanner.nextLine());

        // Birthday
        System.out.println("Geburtsdatum? <<yyyy-MM-dd>>");
        c.setBirthday(LocalDate.parse(scanner.nextLine()));

        // Street
        System.out.println("Straße?");
        c.setStreet(scanner.nextLine());

        // House number
        System.out.println("Hausnummber?");
        c.setHouseNumber(scanner.nextLine());

        // Postcode
        System.out.println("PLZ?");
        c.setStreet(scanner.nextLine());

        // City
        System.out.println("Stadt?");
        c.setCity(scanner.nextLine());

        // Telephone
        System.out.println("Telefon?");
        c.setTelefon(scanner.nextLine());

        // Mobil
        System.out.println("Mobil?");
        c.setMobil(scanner.nextLine());

        // Telefax
        System.out.println("Telefax?");
        c.setTelefax(scanner.nextLine());

        // E-Mail
        System.out.println("E-Mail?");
        c.setEmail(scanner.nextLine());

        // Newsletter
        System.out.println("Newsletter?");
        c.setNewsletter(scanner.nextBoolean());
    }

}
