package service;

import database.Database;
import modell.Customer;

public class CustomerOperations {

    // TODO: Klassenbezeichnung ändern und für jede CRUD Methode eine Klasse erstellen
    // TODO: Ein- und Ausgabe nur im Controller/ View und raus aus dem Service

    public static boolean insertCostumerToDatabase(Customer customer, Database database){
        try{

            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
