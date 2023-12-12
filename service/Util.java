package service;

import modell.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Util {

    //Constructor
    private Util(){}

    //Methods
    public static String convertNullToBusinessLanguage(String value){
        if(value==null){
            return "Kein Wert vorhanden.";
        }
        return value;
    }
    public static String convertBooleanToBusinessLanguage(boolean value){
        if(value){
            return "Abonniert";
        } else{
            return "Kein Abonnent";
        }
    }
    public static String formateDate(ResultSet resultSet) throws SQLException {
        java.sql.Date dateFromDatabase = resultSet.getDate("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateFromDatabase);
    }
    public static String customerDataInSqlValues(Customer customer) {
        return "'" + customer.getGender() + "', '" + customer.getTitle() + "', '"
                + customer.getName() + "', '" + customer.getFamilyName() + "', '" + customer.getBirthday()
                + "', '" + customer.getStreet() + "', '" + customer.getHouseNumber() + "', '" + customer.getPostcode() + "', '"
                + customer.getCity() + "', '" + customer.getTelefon() + "', '" + customer.getMobil() + "', '"
                + customer.getTelefax() + "', '" + customer.getEmail() + "', " + customer.getNewsletter() + ")";
    }
}
