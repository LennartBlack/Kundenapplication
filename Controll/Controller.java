package Controll;

import Database.Database;

import java.util.Scanner;

public class Controller {
    private Database mydb;
    public Controller(Database mydb){
        this.mydb = mydb;
    }
    public void askWhatToDo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Aktion möchtest du als nächstes ausführen? ");
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
    private void searchCostumer(){

    }
    private void updateCostumer(){

    }
    private void deleteCostumer(){

    }
    private void createCostumer(){

    }
}
