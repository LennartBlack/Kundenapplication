package controller;

import database.Database;
import modell.Customer;
import service.CustomerOperations;
import service.MapCustomerOperations;
import view.ConsoleOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class Controller {
    private Database database;
    ConsoleOutput consoleOutput;
    CustomerOperations customerOperations;
    private String query;
    private Scanner scanner;
    private int benutzereingabe;
    private MapCustomerOperations queryConvert;
    public Controller(Database db) throws SQLException, ClassNotFoundException {
        this.database = db;
        this.consoleOutput = new ConsoleOutput(db);
        this.customerOperations = new CustomerOperations(db);
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
                //query() kann null returnen
                ResultSet resultSet = database.executeQuery(sqlstringquery);
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
                Customer customer = createCustomer();
                this.customerOperations.insertCostumerToDatabase(customer);
                ConsoleOutput.newCustomerCreated(customer);
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
    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        // Gender
        System.out.println("Gender?");
        System.out.println("1 für Herr");
        System.out.println("2 für Frau");
        System.out.println("3 für Divers");
        int gender = scanner.nextInt();
        switch (gender) {
            case 1 -> customer.setGender("Herr");
            case 2 -> customer.setGender("Frau");
            case 3 -> customer.setGender("Divers");
            default -> customer.setGender(null);
        }

        // Titel
        System.out.println("Titel?");
        System.out.println("0 für keinen Titel");
        System.out.println("1 für Dr.");
        System.out.println("2 für Prof.");
        int titel = scanner.nextInt();
        switch (titel) {
            case 0 -> customer.setTitle("");
            case 1 -> customer.setTitle("Dr.");
            case 2 -> customer.setTitle("Prof.");
            default -> customer.setTitle(null);
        }
        customer.setName(scanner.nextLine());

        // Name
        System.out.println("Vorname?");
        customer.setName(scanner.nextLine());
        // Family name
        System.out.println("Nachname?");
        customer.setFamilyName(scanner.nextLine());

        // Birthday
        System.out.println("Geburtsdatum? <<yyyy-MM-dd>>");
        customer.setBirthday(LocalDate.parse(scanner.nextLine()));

        // Street
        System.out.println("Straße?");
        customer.setStreet(scanner.nextLine());

        // House number
        System.out.println("Hausnummber?");
        customer.setHouseNumber(scanner.nextLine());

        // Postcode
        System.out.println("PLZ?");
        customer.setPlz(scanner.nextLine());

        // City
        System.out.println("Stadt?");
        customer.setCity(scanner.nextLine());

        // Telephone
        System.out.println("Telefon?");
        customer.setTelefon(scanner.nextLine());

        // Mobil
        System.out.println("Mobil?");
        customer.setMobil(scanner.nextLine());

        // Telefax
        System.out.println("Telefax?");
        customer.setTelefax(scanner.nextLine());

        // E-Mail
        System.out.println("E-Mail?");
        customer.setEmail(scanner.nextLine());

        // Newsletter
        System.out.println("Newsletter?");
        customer.setNewsletter(scanner.nextBoolean());

        return customer;
    }

}
