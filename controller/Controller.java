package controller;

import modell.Customer;
import service.CreateCustomer;
import service.InsertCustomer;
import view.ConsoleOutput;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

// TODO Dibos io klasse verwenden
public class Controller {
    // Attribute
    InsertCustomer insertCustomer;
    private Scanner scanner;

    // Constructor
    public Controller(){
    }
    // TODO nach Deklarationsblöcken (Attribute, Konstruktoren, Methoden, GEtter und Setter) immer Leerzeilen

    // Methods
    public void determineNextAction() throws SQLException {
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
        this.scanner = new Scanner(System.in);
        System.out.println("1 für Kunden suchen");
        System.out.println("2 für Kunden updaten");
        System.out.println("3 für Kunden löschen");
        System.out.println("4 für Kunden anlegen");
        System.out.println("5 Anwendung beenden");

        int benutzereingabe = scanner.nextInt();

        switch (benutzereingabe) {
            case 1 -> {
                // TODO eigenen Customer anlegen statt abfragen
                // Hier Methoden zur Kundensuche einbinden
                /*String sqlstringquery = "SELECT * FROM Costumer_application.costumer WHERE name='Saskia'";
                //query() kann null returnen
                ResultSet resultSet = database.executeQuery(sqlstringquery);

                Customer[] c = MapCustomerOperations.mapCustomerFromDatabase(resultSet);
                for (Customer customer : c) {
                    ConsoleOutput.kundenausgabe(customer);
                }*/

                System.out.println("Die Möglichkeit zur Kundensuche ist noch nicht implementiert. Die Ausgabe aber schon.");
                Customer customer = new Customer();
                customer.setId(0);
                customer.setGender("Herr");
                customer.setTitle("Dr.");
                customer.setName("Max");
                customer.setFamilyName("Mustermann");
                customer.setBirthday(LocalDate.parse("1900-12-31"));
                customer.setStreet("Musterstrasse");
                customer.setHouseNumber("1");
                customer.setPlz("12345");
                customer.setCity("Musterdorf");
                customer.setMobil("01234567");
                customer.setTelefon("+49 30 123456789");
                customer.setEmail("m.m@dein-email-provider.de");
                customer.setNewsletter(true);
                ConsoleOutput.kundenausgabe(customer);

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
                Customer customer = CreateCustomer.createCustomer();

                System.out.println("Test1");
                if(InsertCustomer.insertCostumerToDatabase(customer)) {
                    ConsoleOutput.newCustomerCreated(customer);
                }
                else{
                    ConsoleOutput.failedToCreateCustomer();
                }
                System.out.println("Test2");
                determineNextAction();
            }
            case 5 -> {
                System.out.println("Die Anwendung wird beendet.");
                System.exit(1);
            }
            default -> {}
        }
        scanner.close();
    }


}
