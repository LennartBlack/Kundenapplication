import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
public class Test {
    public static Scanner scanner;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
         System.out.println();
                System.out.println("Die Möglichkeit zur Kundensuche ist noch nicht implementiert. Die Ausgabe aber schon.");
                Customer customer1 = new Customer();
                customer1.setCustomerNumber(0);
                customer1.setGender("Herr");
                customer1.setTitle("Dr.");
                customer1.setName("Max");
                customer1.setFamilyName("Mustermann");
                customer1.setBirthday(LocalDate.parse("1900-12-31"));
                customer1.setStreet("Musterstrasse");
                customer1.setHouseNumber("1");
                customer1.setPostcode("12345");
                customer1.setCity("Musterdorf");
                customer1.setMobil("01234567");
                customer1.setTelefon("+49 30 123456789");
                customer1.setTelefax("+49 30 234567891");
                customer1.setEmail("max@dein-email-provider.de");
                customer1.setNewsletter(true);
                ConsoleOutput.kundenausgabe(customer1);


                Customer customer2 = new Customer();
                customer2.setCustomerNumber(1);
                customer2.setName("Lea");
                customer2.setFamilyName("Musterfrau");
                customer2.setStreet("Musterstrasse");
                customer2.setHouseNumber("1");
                customer2.setPostcode("12345");
                customer2.setCity("Musterdorf");
                customer2.setTelefon("+49 30 123456789");
                customer2.setEmail("lea@dein-email-provider.de");
                customer2.setNewsletter(false);
                //ConsoleOutput.kundenausgabe(customer2);

         */


        /*String zahl1 = "1";
        String zahl2 = "2";
        String zahl5 = "5";


        System.out.println();
        Test.scanner = new Scanner(System.in);
        System.out.println("**********************");
        twoInputs(zahl1, zahl5);
        System.out.println("**********************");

        System.out.println();

        Test.scanner = new Scanner(System.in);
        System.out.println("**********************");
        twoInputs(zahl2, zahl5);
        System.out.println("**********************");
        System.out.println();

        Test.scanner = new Scanner(System.in);
        System.out.println("**********************");
        String[] testArray = new String[]{"1", "2", "Max", "Mustermann", "Weg", "3b", "12345", "Burghausen", "123", "456", "789", "mm@ewe.de"};
        //kundenanlegung();
        System.out.println("**********************");
         */
        Test.scanner = new Scanner(System.in);

        System.out.println();
        String a = "2345";
        a = scanner.nextLine();
        System.out.println(a.matches("\\d+"));

    }

    private static void twoInputs(String input1, String input2) throws SQLException, ClassNotFoundException {
        switch (input1) {
            case "1" -> System.out.print("Test: Kunden suchen");
            case "2" -> System.out.print("Test: Kunden updaten");
            case "3" -> System.out.print("Test: Kunden löschen");
            case "4" -> System.out.print("Test: Kunden erstellen");
            case "5" -> System.out.print("Test: Anwendung über Menü beenden");
            default -> {}
        }
        switch (input2) {
            case "1" -> System.out.println(" und Kunden suchen.");
            case "2" -> System.out.println(" und Kunden updaten.");
            case "3" -> System.out.println(" und Kunden löschen.");
            case "4" -> System.out.println(" und Kunden erstellen.");
            case "5" -> System.out.println(" und Anwendung über Menü beenden.");
            default -> {}
        }
        System.out.println(input1 + " und " + input2);
        System.out.println("-----------");

        ByteArrayInputStream input1InByte = new ByteArrayInputStream(input1.getBytes());
        ByteArrayInputStream input2InByte = new ByteArrayInputStream(input2.getBytes());
        System.setIn(input1InByte);
        System.setIn(input2InByte);
        scanner.close();
        Main.main(null);
        System.out.println("-----------");
    }

   // private static void kundenanlegung(String[] stringArray, DateFormat date, boolean newsletter, )
}
