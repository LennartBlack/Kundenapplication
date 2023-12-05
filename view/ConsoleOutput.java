package view;

import modell.Customer;

import static service.Util.convertBooleanToBusinessLanguage;
import static service.Util.convertNullToBusinessLanguage;

public class ConsoleOutput {
    private ConsoleOutput(){
    }
    public static void kundenausgabe(Customer customer){
        System.out.println("****************");
        System.out.println("***Zur Person***");
        System.out.println("ID: " + customer.getId());
        System.out.println("Anrede:  " + convertNullToBusinessLanguage(customer.getGender()));
        System.out.println("Titel: " + convertNullToBusinessLanguage(customer.getTitle()));
        System.out.println("Vorname: " + convertNullToBusinessLanguage(customer.getName()));
        System.out.println("Nachname: " + convertNullToBusinessLanguage(customer.getFamilyName()));
        System.out.println("Geburtsdatum: " + convertNullToBusinessLanguage(customer.getBirthday()));
        System.out.println();
        System.out.println("***Adresse***");
        System.out.println("Straße: " + convertNullToBusinessLanguage(customer.getStreet()));
        System.out.println("Hausnummer: " + convertNullToBusinessLanguage(customer.getHouseNumber()));
        System.out.println("PLZ: " + convertNullToBusinessLanguage(customer.getPlz()));
        System.out.println("Stadt: " + convertNullToBusinessLanguage(customer.getCity()));
        System.out.println();
        System.out.println("***Kontakt***");
        System.out.println("Telefon: " + convertNullToBusinessLanguage(customer.getTelefon()));
        System.out.println("Mobil: " + convertNullToBusinessLanguage(customer.getMobil()));
        System.out.println("Telefax: " + convertNullToBusinessLanguage(customer.getTelefax()));
        System.out.println("Email: " + convertNullToBusinessLanguage(customer.getEmail()));
        System.out.println();
        System.out.println("***Sonstiges***");
        System.out.println("Newsletter: " + convertBooleanToBusinessLanguage(customer.getNewsletter()));
        System.out.println();
        System.out.println("****************");
        System.out.println();
        System.out.println();
    }

    public static void printString(String string){
        System.out.println(string);
    }
    public static void newCustomerCreated(Customer customer) {
        System.out.println("Der Kunde wurde erfolgreich im KMS eingetragen mit der Kundennummer: " + customer.getId());
    }
    public static void failedToCreateCustomer() {
        System.out.println("Die eingegebenen Daten sind nicht valide.");
    }
}