package service;

import database.Database;
import modell.Customer;

import java.sql.SQLException;

public class CustomerOperations {
    private Database database;
    // TODO: Klassenbezeichnung ändern und für jede CRUD Methode eine Klasse erstellen
    // TODO: Ein- und Ausgabe nur im Controller/ View und raus aus dem Service

    public CustomerOperations(Database database){
        this.database = database;
    }
    public void insertCostumerToDatabase(Customer customer){
        try{
            String insertQueryPreset = "Insert into Costumer_application.customer" +
                    " (gender, titel, name, family_name, birthday, street, house_number, " +
                    "postcode, city, telephone, mobil, telefax, email, newsletter) values ";
            String insertQuery = insertQueryPreset + CustomerOperations.customerDataInSqlValues(customer);
            customer.setId(this.database.insertStatement(insertQuery));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private static String customerDataInSqlValues(Customer customer) {
        return "('" + customer.getGender() + "', '" + customer.getTitle() + "', '"
                + customer.getName() + "', '" + customer.getFamilyName() + "', '" + customer.getBirthday().toString()
                + "', '" + customer.getStreet() + "', '" + customer.getHouseNumber() + "', '" + customer.getPlz() + "', '"
                + customer.getCity() + "', '" + customer.getTelefon() + "', '" + customer.getMobil() + "', '"
                + customer.getTelefax() + "', '" + customer.getEmail() + "', " + customer.getNewsletter() + ")";
    }
}
