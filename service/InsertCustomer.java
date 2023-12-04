package service;

import database.Database;
import modell.Customer;
import java.util.Optional;

public class InsertCustomer {
    // TODO: Klassenbezeichnung ändern und für jede CRUD Methode eine Klasse erstellen
    // TODO: Ein- und Ausgabe nur im Controller/ View und raus aus dem Service

    private InsertCustomer(){
    }
    public void insertCostumerToDatabase(Customer customer){
        try{
            // TODO PreparedStatement benutzen im SQL-Injections vorzubeugen
            // TODO mit "(?,?,?)" arbeiten
            // TODO auslagern in Datenbank "insert.." Part
            // TODO Exceptionbehandlung generell
            String insertQueryPreset = "Insert into Costumer_application.customer" +
                    " (gender, titel, name, family_name, birthday, street, house_number, " +
                    "postcode, city, telephone, mobil, telefax, email, newsletter) values (?,?)";
            String insertQuery = insertQueryPreset + InsertCustomer.customerDataInSqlValues(customer);
            Optional<Integer> customerId = Database.insertStatement(insertQuery);
            if(customerId.isPresent()){
                customer.setId(customerId.get());
            } else{
                // TODO Fehlerbehandlung
                // TODO Optional einarbeiten
            }
        }
        catch (Exception e){
            System.out.println("Ein Unerwarteter Fehler ist aufgetreten.");
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