package service;

import controller.Controller;
import repository.Database;
import service.exceptions.DeleteCustomerFailed;

import java.util.Scanner;

public class DeleteCustomer {

    private DeleteCustomer(){
    }

    public static void deleteCustomer() throws DeleteCustomerFailed {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Kundennummer des Kunden ein, der gelöscht werden soll.");
        int customerNumberToDelete = -1;
        while(customerNumberToDelete<1){
            customerNumberToDelete = scanner.nextInt();
        }
        int affectedRows = Database.executeUpdate("Delete from Costumer_application.customer where id=" + customerNumberToDelete);
        if(affectedRows == -1){
            throw new DeleteCustomerFailed();
        }
        System.out.println(affectedRows + "Kunde(n) wurde(n) gelöscht.");
    }
}