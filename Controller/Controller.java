package Controller;

import Database.Database;
import Modell.Costumer;
import Service.ConvertSqlQueryIntoCostumerObjService;
import View.ConsoleOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private Database mydb;
    ConsoleOutput co;
    private String query;
    private Scanner scanner;
    private int benutzereingabe;
    private ConvertSqlQueryIntoCostumerObjService queryConvert;
    public Controller(Database mydb) throws SQLException, ClassNotFoundException {
        this.mydb = mydb;
        this.co = new ConsoleOutput(mydb);
    }
    public void askWhatToDo() throws SQLException {
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
        this.scanner = new Scanner(System.in);
        System.out.println("1 für Kunden suchen");
        System.out.println("2 für Kunden updaten");
        System.out.println("3 für Kunden löschen");
        System.out.println("4 für Kunden anlegen");
        System.out.println("5 Anwendung beenden");
        this.benutzereingabe = scanner.nextInt();
        switch (benutzereingabe) {
            case 1 -> {
                String sqlstringquery = "SELECT * FROM Costumer_application.costumer WHERE name='Saskia'";
                ResultSet resultSet = mydb.query(sqlstringquery);
                Costumer[] c = ConvertSqlQueryIntoCostumerObjService.convertResultSetIntoCostumerObj(resultSet);
                for (Costumer costumer : c) {
                    ConsoleOutput.kundenausgabe(costumer);
                }
                // Hier Methoden zur Kundensuche einbinden
                System.out.println("Die Möglichkeit zur Kundensuche ist noch nicht implementiert.");
                askWhatToDo();
            }
            case 2 -> {
                // Hier Methoden zur Kundenänderung einbinden
                System.out.println("Die Möglichkeit zur Kundenänderung ist noch nicht implementiert.");
                askWhatToDo();
            }
            case 3 -> {
                // Hier Methoden zur Kundenlöschung einbinden
                System.out.println("Die Möglichkeit zur Kundenlöschung ist noch nicht implementiert.");
                askWhatToDo();
            }
            case 4 -> {
                // Hier Methoden zur Kundenanlegung einbinden
                System.out.println("Die Möglichkeit zur Kundenanlegung ist noch nicht implementiert.");
                askWhatToDo();
            }
            case 5 -> {
                System.out.println("Die Anwendung wird beendet.");
                mydb.closeConnection();
            }
            default -> {
                ;
            }
        }
        scanner.close();
    }

}
