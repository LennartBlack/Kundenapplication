package service;

import modell.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MapCustomer {
    //Constructor
    public MapCustomer(){
    }

    //Methods
    public static Customer[]  mapCustomerFromDatabase(ResultSet resultSet) throws SQLException {
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
            customer.setBirthday(LocalDate.parse(Util.formateDate(resultSet)));
            // Street
            customer.setStreet(resultSet.getNString(7));
            // House number
            customer.setHouseNumber(resultSet.getNString(8));
            // Postcode
            customer.setPostcode(resultSet.getNString(9));
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


}
