package service;

import repository.Database;
import modell.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertCustomer {
    //Constructor
    private InsertCustomer(){
    }

    //Methods
    public static boolean insertCostumerToDatabase(Customer customer){
        try{
            // TODO Exceptionbehandlung generell
            String insertQueryPreset = "Insert into Costumer_application.customer" +
                    " (gender, titel, name, family_name, birthday, street, house_number, " +
                    "postcode, city, telephone, mobil, telefax, email, newsletter) values (";
            String insertQuery = insertQueryPreset + Util.customerDataInSqlValues(customer);
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


}
