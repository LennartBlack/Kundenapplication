package Controll;

import Database.Database;
import Modell.Costumer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private Database mydb;
    private String query;
    private Scanner scanner;
    private int benutzereingabe;
    public Controller(Database mydb){
        this.mydb = mydb;
    }
    public void askWhatToDo() throws SQLException {
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
        this.scanner = new Scanner(System.in);
        System.out.println("1 für Kunden suchen");
        System.out.println("2 für Kunden updaten");
        System.out.println("3 für Kunden löschen");
        System.out.println("4 für Kunden anlegen");
        this.benutzereingabe = scanner.nextInt();
        switch (benutzereingabe) {
            case 1 -> {
                searchCostumer();
            }
            case 2 -> {
                updateCostumer();
            }
            case 3 -> {
                deleteCostumer();
            }
            case 4 -> {
                createCostumer();
            }
            default -> {
                ;
            }
        }
        scanner.close();
    }
    private void searchCostumer() throws SQLException {
        setQuery();
        PreparedStatement query = mydb.getConnection().prepareStatement(getQuery());
    }

    private void setQuery() {
        this.query = this.scanner.next();
    }
    private String getQuery(){
        return this.query;
    }

    private void updateCostumer(Costumer costumer){
        System.out.println("Welchen Wert möchtest du ändern?");
        System.out.println("1: Anrede");
        System.out.println("2: Titel");
        System.out.println("3: Name");
        System.out.println("4: familyName");
        System.out.println("5: birthday");
        System.out.println("6: street");
        System.out.println("7: houseNumber");
        System.out.println("8: plz");
        System.out.println("9: city");
        System.out.println("10: telephone");
        System.out.println("11: mobil");
        System.out.println("12: telefax");
        System.out.println("13: email");
        System.out.println("14: newsletter");
        this.benutzereingabe = scanner.nextInt();
        switch (benutzereingabe){
            case 1 -> {
                System.out.println("Mögliche Anreden sind:");
                System.out.println("1: Männlich");
                System.out.println("2: Weiblich");
                System.out.println("3: Divers");
                this.benutzereingabe = scanner.nextInt();
                costumer.setAnrede(benutzereingabe);
            }
        }
    }
    private void deleteCostumer(){

    }
    private void createCostumer(){

    }
}
