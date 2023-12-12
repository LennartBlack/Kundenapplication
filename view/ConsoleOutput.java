package view;

import modell.Customer;

import static service.Util.convertBooleanToBusinessLanguage;
import static service.Util.convertNullToBusinessLanguage;

public class ConsoleOutput {
    private ConsoleOutput(){
    }
    public static void kundenausgabe(Customer customer){
        System.out.println();
        System.out.println("****************");
        System.out.println("***Zur Person***");
        System.out.println("ID: " + customer.getCustomerNumber());
        if(valueExists(customer.getGender())){
            System.out.println("Anrede:  " + customer.getGender());
        }
        if(valueExists(customer.getTitle())){
            System.out.println("Titel: " + customer.getTitle());
        }
        if(valueExists(customer.getName())){
            System.out.println("Vorname: " + customer.getName());
        }
        if(valueExists(customer.getFamilyName())){
            System.out.println("Nachname: " + customer.getFamilyName());
        }
        if(valueExists(customer.getBirthday())){
            System.out.println("Geburtsdatum: " + customer.getBirthday());
        }
        System.out.println();
        System.out.println("***Adresse***");
        System.out.println("Straße: " + convertNullToBusinessLanguage(customer.getStreet()));
        System.out.println("Hausnummer: " + convertNullToBusinessLanguage(customer.getHouseNumber()));
        System.out.println("PLZ: " + convertNullToBusinessLanguage(customer.getPostcode()));
        System.out.println("Stadt: " + convertNullToBusinessLanguage(customer.getCity()));
        System.out.println();
        System.out.println("***Kontakt***");
        if(valueExists(customer.getTelefon())){
            System.out.println("Telefon: " + customer.getTelefon());
        }
        if(valueExists(customer.getMobil())){
            System.out.println("Mobil: " + customer.getMobil());
        }
        if(valueExists(customer.getMobil())){
            System.out.println("Mobil: " + customer.getMobil());
        }
        if(valueExists(customer.getTelefax())){
            System.out.println("Telefax: " + customer.getTelefax());
        }
        if(valueExists(customer.getEmail())){
            System.out.println("Email: " + customer.getEmail());
        }
        System.out.println();
        System.out.println("***Sonstiges***");
        System.out.println("Newsletter: " + convertBooleanToBusinessLanguage(customer.getNewsletter()));
        System.out.println();
        System.out.println("****************");
        System.out.println();
        System.out.println();
    }

    private static boolean valueExists(String value) {
        return value!=null;
    }

    public static void greetUser(){
        System.out.println("Herzlich Willkommen in dem Kundenmanagementsystem.");
        System.out.println("Dies ist eine konsolenbasierte Anwendung");
        System.out.println("Die Eingabe erfolgt rein über die Tastatur.");
    }
    public static void printString(String string){
        System.out.println(string);
    }
    public static void newCustomerCreated(Customer customer) {
        System.out.println("Der Kunde wurde erfolgreich im KMS eingetragen mit der Kundennummer: " + customer.getCustomerNumber());
    }
    public static void failedToCreateCustomer() {
        System.out.println("Die eingegebenen Daten sind nicht valide.");
    }
}