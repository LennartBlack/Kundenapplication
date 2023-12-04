package service;

import modell.Customer;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateCustomer {
    private CreateCustomer(){
    }
    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

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
        System.out.println("Vorname?");
        customer.setName(scanner.nextLine());

        System.out.println("Nachname?");
        customer.setFamilyName(scanner.nextLine());

        System.out.println("Geburtsdatum? <<yyyy-MM-dd>>");
        String birthday = scanner.nextLine();
        try{
            customer.setBirthday(LocalDate.parse(birthday));
        }
        catch(DateTimeException e){
            customer.setBirthday(null);
        }

        System.out.println("Straße?");
        customer.setStreet(scanner.nextLine());

        System.out.println("Hausnummber?");
        customer.setHouseNumber(scanner.nextLine());

        System.out.println("PLZ?");
        customer.setPlz(scanner.nextLine());

        System.out.println("Stadt?");
        customer.setCity(scanner.nextLine());

        System.out.println("Telefon?");
        customer.setTelefon(scanner.nextLine());

        System.out.println("Mobil?");
        customer.setMobil(scanner.nextLine());

        System.out.println("Telefax?");
        customer.setTelefax(scanner.nextLine());

        System.out.println("E-Mail?");
        customer.setEmail(scanner.nextLine());

        System.out.println("Newsletter? 'j' or 'n'");
        customer.setNewsletter(scanner.nextLine().equals("y"));

        return customer;
    }
}
