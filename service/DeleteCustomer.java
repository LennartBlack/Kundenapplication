package service;

import repository.Database;
import service.exceptions.DeleteCustomerFailed;
import java.util.Scanner;

public class DeleteCustomer {

    //Constructor
    private DeleteCustomer(){
    }

    //Methods
    public static void deleteCustomer() throws DeleteCustomerFailed {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Kundennummer des Kunden ein, der gelöscht werden soll.");
        int customerNumberToDelete = -1;
        while(customerNumberToDelete<1){
            customerNumberToDelete = scanner.nextInt();
        }
        int affectedRows = Database.executeUpdate("Delete from Costumer_application.customer where customer_number=" + customerNumberToDelete);
        if(affectedRows == -1){
            throw new DeleteCustomerFailed();
        }
        System.out.println("Kunde mit der Kundennummer '" + affectedRows + "' wurde gelöscht.");
    }
}