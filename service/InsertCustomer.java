package service;

import repository.Database;
import modell.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class InsertCustomer {
      private InsertCustomer(){
    }
    public static boolean insertCostumerToDatabase(Customer customer){
        try{
            // TODO Exceptionbehandlung generell
            String insertQueryPreset = "Insert into Costumer_application.customer" +
                    " (gender, titel, name, family_name, birthday, street, house_number, " +
                    "postcode, city, telephone, mobil, telefax, email, newsletter) values (";
            String insertQuery = insertQueryPreset + InsertCustomer.customerDataInSqlValues(customer);
            PreparedStatement insertStatement = Database.getConnection().prepareStatement(insertQuery);
            ResultSet resultSet = insertStatement.executeQuery();
            if(resultSet.next()){
                customer.setCustomerNumber(resultSet.getInt(1));
                return true;
            } else{
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Ein Unerwarteter Fehler ist aufgetreten.");
            return false;
        }
    }

    private static String customerDataInSqlValues(Customer customer) {
        return "'" + customer.getGender() + "', '" + customer.getTitle() + "', '"
                + customer.getName() + "', '" + customer.getFamilyName() + "', '" + customer.getBirthday()
                + "', '" + customer.getStreet() + "', '" + customer.getHouseNumber() + "', '" + customer.getPlz() + "', '"
                + customer.getCity() + "', '" + customer.getTelefon() + "', '" + customer.getMobil() + "', '"
                + customer.getTelefax() + "', '" + customer.getEmail() + "', " + customer.getNewsletter() + ")";
    }
}
