package Controll;

import Database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private Database mydb;
    private String query;
    private Scanner scanner;
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
        int benutzereingabe = scanner.nextInt();
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

    private void updateCostumer(){

    }
    private void deleteCostumer(){

    }
    private void createCostumer(){

    }
}
