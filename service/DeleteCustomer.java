package service;

import repository.Database;

import java.util.Scanner;

public class DeleteCustomer {

    private DeleteCustomer(){
    }

    public static void deleteCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Kundennummer des Kunden ein, der gelöscht werden soll.");
        int customerNumberToDelete = -1;
        while(customerNumberToDelete<1){
            customerNumberToDelete = scanner.nextInt();
        }
        Database.executeQuery("Delete from Costumer_application.customer where id=" + customerNumberToDelete);
    }
}
