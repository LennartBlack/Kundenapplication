package controller;

import modell.Customer;
import service.CreateCustomer;
import service.DeleteCustomer;
import service.InsertCustomer;
import service.exceptions.DeleteCustomerFailed;
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
        System.out.println();
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

                System.out.println();
                System.out.println("Die Möglichkeit zur Kundensuche ist noch nicht implementiert. Die Ausgabe aber schon.");
                Customer customer1 = new Customer();
                customer1.setId(0);
                customer1.setGender("Herr");
                customer1.setTitle("Dr.");
                customer1.setName("Max");
                customer1.setFamilyName("Mustermann");
                customer1.setBirthday(LocalDate.parse("1900-12-31"));
                customer1.setStreet("Musterstrasse");
                customer1.setHouseNumber("1");
                customer1.setPlz("12345");
                customer1.setCity("Musterdorf");
                customer1.setMobil("01234567");
                customer1.setTelefon("+49 30 123456789");
                customer1.setTelefax("+49 30 234567891");
                customer1.setEmail("max@dein-email-provider.de");
                customer1.setNewsletter(true);
                ConsoleOutput.kundenausgabe(customer1);


                Customer customer2 = new Customer();
                customer2.setId(1);
                customer2.setName("Lea");
                customer2.setFamilyName("Musterfrau");
                customer2.setStreet("Musterstrasse");
                customer2.setHouseNumber("1");
                customer2.setPlz("12345");
                customer2.setCity("Musterdorf");
                customer2.setTelefon("+49 30 123456789");
                customer2.setEmail("lea@dein-email-provider.de");
                customer2.setNewsletter(false);
                //ConsoleOutput.kundenausgabe(customer2);

                System.out.println();
                determineNextAction();
            }
            case 2 -> {
                // Hier Methoden zur Kundenänderung einbinden
                System.out.println("Die Möglichkeit zur Kundenänderung ist noch nicht implementiert.");

                determineNextAction();
            }
            case 3 -> {
                try {
                    DeleteCustomer.deleteCustomer();
                }
                catch (DeleteCustomerFailed e){
                    System.out.println("Auftrag konnte nicht korrekt ausgeführt werden");
                }
                determineNextAction();
            }
            case 4 -> {
                Customer customer = CreateCustomer.createCustomer();
                try {
                    if (InsertCustomer.insertCostumerToDatabase(customer)) {
                        ConsoleOutput.newCustomerCreated(customer);
                    }
                }catch (Exception e) {
                    ConsoleOutput.failedToCreateCustomer();
                }
                finally {
                    determineNextAction();
                }
            }
            case 5 -> {
                System.out.println("Die Anwendung wird beendet.");
                System.exit(1);
            }
            default -> {
                System.out.println("Ungültige Eingabe");
                determineNextAction();
            }
        }
        scanner.close();
    }


}
