package service;

import database.Database;
import modell.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class MapCustomerOperations {
    public MapCustomerOperations(Database db) throws SQLException, ClassNotFoundException {

    }
    public static Customer[] mapCustomerFromDatabase(ResultSet resultSet) throws SQLException {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        while(resultSet.next()) {
            Customer customer = new Customer();
            // Gender
            customer.setGender(resultSet.getNString(2));
            // Titel
            customer.setTitle(resultSet.getNString(3));
            // Name
            customer.setName(resultSet.getNString(4));
            // Family name
            customer.setFamilyName(resultSet.getNString(5));
            // Birthday
            customer.setBirthday(LocalDate.parse(formateDate(resultSet)));
            // Street
            customer.setStreet(resultSet.getNString(7));
            // House number
            customer.setHouseNumber(resultSet.getNString(8));
            // Postcode
            customer.setPlz(resultSet.getNString(9));
            // City
            customer.setCity(resultSet.getString(10));
            // Telephone
            customer.setTelefon(resultSet.getNString(11));
            // Mobil
            customer.setMobil(resultSet.getNString(12));
            // Telefax
            customer.setTelefon(resultSet.getNString(13));
            // E-Mail
            customer.setEmail(resultSet.getNString(14));
            // Newsletter
            customer.setNewsletter(resultSet.getBoolean(15));
            customerArrayList.add(customer);
        }
        return customerArrayList.toArray(new Customer[0]);
    }

    private static String formateDate(ResultSet resultSet) throws SQLException {
        java.sql.Date dateFromDatabase = resultSet.getDate("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateFromDatabase);
    }
}
