package View;

import Database.Database;
import Modell.Costumer;

import java.sql.SQLException;

public class ConsoleOutput {
    Database mydb;
    public ConsoleOutput(Database db){
        this.mydb = db;
    }
    public static void kundenausgabe(Costumer c) throws SQLException {
        System.out.println("***Zur Person***");
        System.out.println("ID: " + c.getID());
        System.out.println("Anrede:  " + c.getGender());
        System.out.println("Titel: " + c.getTitle());
        System.out.println("Vorname: " + c.getName());
        System.out.println("Nachname: " + c.getFamilyName());
        System.out.println("Geburtsdatum: " + c.getBirthday());
        System.out.println();
        System.out.println("***Adresse***");
        System.out.println("Straße: " + c.getStreet());
        System.out.println("Hausnummer: " + c.getHouseNumber());
        System.out.println("PLZ: " + c.getPlz());
        System.out.println();
        System.out.println("***Kontakt***");
        System.out.println("Stadt: " + c.getCity());
        System.out.println("Telefon: " + c.getTelefon());
        System.out.println("Mobil: " + c.getMobil());
        System.out.println("Telefax: " + c.getTelefax());
        System.out.println("Email: " + c.getEmail());
        System.out.println();
        System.out.println("***Sonstiges***");
        System.out.println("Newsletter: " + c.getNewsletter());
        System.out.println();
    }
}