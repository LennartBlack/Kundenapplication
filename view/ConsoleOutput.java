package view;

import database.Database;
import modell.Customer;

import java.sql.SQLException;

public class ConsoleOutput {
    Database database;
    public ConsoleOutput(Database database){
        this.database = database;
    }
    public static void kundenausgabe(Customer customer) throws SQLException {
        System.out.println("***Zur Person***");
        System.out.println("ID: " + customer.getId());
        System.out.println("Anrede:  " + customer.getGender());
        System.out.println("Titel: " + customer.getTitle());
        System.out.println("Vorname: " + customer.getName());
        System.out.println("Nachname: " + customer.getFamilyName());
        System.out.println("Geburtsdatum: " + customer.getBirthday());
        System.out.println();
        System.out.println("***Adresse***");
        System.out.println("Straße: " + customer.getStreet());
        System.out.println("Hausnummer: " + customer.getHouseNumber());
        System.out.println("PLZ: " + customer.getPlz());
        System.out.println();
        System.out.println("***Kontakt***");
        System.out.println("Stadt: " + customer.getCity());
        System.out.println("Telefon: " + customer.getTelefon());
        System.out.println("Mobil: " + customer.getMobil());
        System.out.println("Telefax: " + customer.getTelefax());
        System.out.println("Email: " + customer.getEmail());
        System.out.println();
        System.out.println("***Sonstiges***");
        System.out.println("Newsletter: " + customer.getNewsletter());
        System.out.println();
    }
    public static void printString(String string){
        System.out.println(string);
    }

    public static void newCustomerCreated(Customer customer) {
        System.out.println("Der Kunde wurde erfolgreich im KMS eingetragen mit der Kundennummer: " + customer.getId());
    }
}