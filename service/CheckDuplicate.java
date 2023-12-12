package service;

import modell.Customer;
import repository.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckDuplicate {
    public static int checkDuplicate(Customer costumer) {
        try {
            ResultSet resultSet =  Database.executeQuery("SELECT * FROM costumer_application.customer WHERE name = "
                    + costumer.getName() + " AND family_name = " + costumer.getFamilyName() + " AND street = " + costumer.getStreet() + " AND house_number = "
            + costumer.getHouseNumber() + " AND postcode = " + costumer.getPlz() + " AND city = " + costumer.getCity() + ";");
            resultSet.next();
            return resultSet.getInt(1);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}