package service;

import modell.Customer;
import repository.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckDuplicate {

    //Constructor
    private CheckDuplicate(){}

    //Methods
    public static int checkDuplicate(Customer costumer){
        //Checks whether a customer with the exact same name and address already exists
        try {
            ResultSet resultSet = Database.executeQuery("SELECT * FROM costumer_application.customer WHERE name = "
                    + costumer.getName() + " AND family_name = " + costumer.getFamilyName() + " AND street = " + costumer.getStreet() + " AND house_number = "
                    + costumer.getHouseNumber() + " AND postcode = " + costumer.getPostcode() + " AND city = " + costumer.getCity() + ";");
            resultSet.next();
            return resultSet.getInt(1);
        }
        catch (SQLException e){
            System.out.println("Kritischer Fehler. Bitte kontaktieren Sie den Anwendungsadministrator.");
        }
        return -1;
    }
}