package controller;

import modell.Customer;
import service.*;
import service.exceptions.DeleteCustomerFailed;
import view.ConsoleOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// TODO Dibos io klasse verwenden
public class Controller {

    // Constructor
    public Controller(){
    }

    // Methods
    public void determineNextAction() throws SQLException {
        System.out.println();
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 für Kunden suchen");
        System.out.println("2 für Kunden updaten");
        System.out.println("3 für Kunden löschen");
        System.out.println("4 für Kunden anlegen");
        System.out.println("5 Anwendung beenden");

        int benutzereingabe = scanner.nextInt();

        switch (benutzereingabe) {
            case 1 -> {
                ResultSet resultSet = SearchCustomer.searchCustomer();
                if(resultSet.next()) {
                    Customer[] queryResults = MapCustomer.mapResultSetFromDatabase(resultSet);
                    for (Customer customer : queryResults) {
                        ConsoleOutput.kundenausgabe(customer);
                    }
                } else{
                    System.out.println("Keine Ergebnisse.");
                }

                System.out.println();
                determineNextAction();
            }
            case 2 -> {
                System.out.println("Die Möglichkeit der Änderung von Kundendaten ist bisher nicht implementiert.");

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

                //Checks whether a customer with the exact same name and address already exists
                if(CheckDuplicate.checkDuplicate(customer) != -1) {
                    //Not the case: Inserts a new customer into the database
                    try {
                        if (InsertCustomer.insertCostumerToDatabase(customer)) {
                            ConsoleOutput.newCustomerCreated(customer);
                        }
                    } catch (Exception e) {
                        ConsoleOutput.failedToCreateCustomer();
                    }
                } else{
                    System.out.println("Kunde existiert bereits mit der Kundennummer: " + customer.getCustomerNumber());
                }

                determineNextAction();
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
