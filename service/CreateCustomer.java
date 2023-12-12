package service;

import modell.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class CreateCustomer {
    //Constructor
    private CreateCustomer(){
    }

    //Methods
    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Welches Gender hat der Kunde?");
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

        System.out.println("Welche Titel hat der Kunde?");
        String titel = scanner.nextLine();
        titel = scanner.nextLine();
        customer.setTitle(titel);
        System.out.println();

        System.out.println("Wie heißt der Kunde mit Vornamen?");
        String name = scanner.nextLine();
        while (!name.matches("^[a-zA-Z]+$")){
            System.out.println("Der Vorname darf nur Buchstaben enthalten. Bitte erneut versuchen.");
            name = scanner.nextLine();
        }
        customer.setName(name);
        System.out.println();

        System.out.println("Wie heißt der Kunde mit Nachnamen?");
        String familyName = scanner.nextLine();
        while (!familyName.matches("^[a-zA-Z]+$")){
            System.out.println("Der Nachname darf nur Buchstaben enthalten. Bitte erneut versuchen.");
            familyName = scanner.nextLine();
        }
        customer.setFamilyName(familyName);
        System.out.println();

        System.out.println("Geben Sie das Geburtsdatum des Kunden ein. Das Format lautet: <<dd-MM-yyyy>>");
        String birthday = scanner.nextLine();
        while (!isValidDateFormat(birthday,"dd-MM-yyyy")){
            System.out.println("Das Geburtsdatum wurde falsch eingegeben. Bitte erneut versuchen. <<dd-MM-yyyy>>");
            birthday = scanner.nextLine();
        }
        System.out.println();

        System.out.println("Straße?");
        customer.setStreet(scanner.nextLine());
        System.out.println();

        System.out.println("Hausnummber?");
        customer.setHouseNumber(scanner.nextLine());
        System.out.println();

        System.out.println("Geben Sie die Postleitzahl der Wohnadresse des Kunden ein.");
        String postcode = scanner.nextLine();
        while (!postcode.matches("\\d+") && (postcode.length() != 5)){
            System.out.println("Fehlerhafte Eingabe. Geben Sie die Postleitzahl der Wohnadresse des Kunden ein.");
            postcode = scanner.nextLine();
        }
        customer.setPostcode(postcode);
        System.out.println();

        System.out.println("Geben Sie die Stadt/ Ort der Wohnadresse des Kunden ein?");
        String city = scanner.nextLine();
        while(!city.matches("^[a-zA-Z]+$")){
            System.out.println("Fehlerhafte Eingabe. Geben Sie die Stadt/ Ort der Wohnadresse des Kunden ein?");
            city = scanner.nextLine();
        }
        customer.setCity(city);
        System.out.println();

        System.out.println("Geben Sie die Telefonnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
        String telefon = scanner.nextLine();
        while(!telefon.matches("^0\\d+")){
            System.out.println("Fehlerhafte Eingabe. Geben Sie die Telefonnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
            telefon = scanner.nextLine();
        }
        customer.setTelefon(telefon);
        System.out.println();

        System.out.println("Geben Sie die Mobilnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
        String mobil = scanner.nextLine();
        while(!mobil.matches("^0\\d+")){
            System.out.println("Fehlerhafte Eingabe. Geben Sie die Mobilnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
            mobil = scanner.nextLine();
        }
        customer.setMobil(mobil);
        System.out.println();

        System.out.println("Geben Sie die Telefaxnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
        String telefax = scanner.nextLine();
        while(!telefax.matches("^0\\d+")) {
            System.out.println("Fehlerhafte Eingabe. Geben Sie die Mobilnummer des Kunden ein. Beginnend mit einer 0. Eingabe ohne +,(,),...");
            telefax = scanner.nextLine();
        }
        customer.setTelefax(telefax);
        System.out.println();

        System.out.println("Geben Sie die E-Mail-Adresse des Kunden ein.");
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
            System.out.println("Ungültige Eingabe. Soll der Newsletter abonniert werden? 'j' or 'n'");
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
    /**
     *
     * @param value to be checked whether it is in the correct format or not
     * @param format String which sets a SimpleDateFormat to parse the parameter value
     * @return whether the value is in the correct format or not
     */
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
