package service;

import modell.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;


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

        System.out.println();

        System.out.println("Vorname?");
        String name = scanner.nextLine();
        while (!name.matches("^[a-zA-Z]+$")){
            System.out.println("Vorname?");
            name = scanner.nextLine();
        }
        customer.setName(name);
        System.out.println();

        System.out.println("Nachname?");
        String familyName = scanner.nextLine();
        while (!familyName.matches("^[a-zA-Z]+$")){
            System.out.println("Nachname?");
            familyName = scanner.nextLine();
        }
        customer.setFamilyName(familyName);
        System.out.println();

        System.out.println("Geburtsdatum? <<yyyy-MM-dd>>");
        String birthday = scanner.nextLine();
        while (!isValidDateFormat(birthday,"dd-MM-yyyy")){
            System.out.println("Geburtsdatum? <<yyyy-MM-dd>>");
            birthday = scanner.nextLine();
        }
        System.out.println();

        System.out.println("Straße?");
        customer.setStreet(scanner.nextLine());
        System.out.println();

        System.out.println("Hausnummber?");
        customer.setHouseNumber(scanner.nextLine());
        System.out.println();

        System.out.println("PLZ?");
        String postcode = scanner.nextLine();
        while (postcode.matches("^[a-zA-Z]+$")){
            System.out.println("PLZ?");
            postcode = scanner.nextLine();
        }
        customer.setPlz(postcode);
        System.out.println();

        System.out.println("Stadt?");
        String city = scanner.nextLine();
        while(city.matches("^[a-zA-Z]+$")){
            System.out.println("Stadt?");
            city = scanner.nextLine();
        }
        customer.setCity(city;
        System.out.println();

        System.out.println("Telefon?");
        String telefon = scanner.nextLine();
        while(!telefon.matches("\\d+")){
            System.out.println("Telefon?");
            telefon = scanner.nextLine();
        }
        customer.setTelefon(telefon);
        System.out.println();

        System.out.println("Mobil?");
        String mobil = scanner.nextLine();
        while(!mobil.matches("\\d+")){
            System.out.println("Mobil?");
            mobil = scanner.nextLine();
        }
        customer.setMobil(mobil);
        System.out.println();

        String telefax = scanner.nextLine();
        while(!telefax.matches("\\d+")) {
            System.out.println("Telefax?");
            telefax = scanner.nextLine();
        }
        customer.setTelefax(telefax);
        System.out.println();

        System.out.println("E-Mail?");
        String emailInput;
        emailInput = scanner.nextLine();
        while(!emailInput.contains("@")){
            System.out.println("Ungültige E-Mail-Adresse. Bitte erneut eingeben.");
            emailInput = scanner.nextLine();
        }
        customer.setEmail(scanner.nextLine());
        System.out.println();

        System.out.println("Newsletter? 'j' or 'n'");
        String newsletterInput;
        newsletterInput = scanner.nextLine();
        while(!newsletterInput.equals('j') || !newsletterInput.equals('n')){
            System.out.println("Ungültige Eingabe. Bitte erneut eingeben.");
            newsletterInput = scanner.nextLine();
        }
        if(newsletterInput.equals('j')) {
            customer.setNewsletter(true);
        } else{
            customer.setNewsletter(false);
        }
        System.out.println();



        return customer;
    }

    private static boolean isValidDateFormat(String value, String format) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            sdf.parse(value);
            return true;
        } catch (ParseException e){
            return false;
        }
    }
}
