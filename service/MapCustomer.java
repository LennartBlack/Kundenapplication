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
    public static Customer[] mapResultSetFromDatabase(ResultSet resultSet) throws SQLException {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        Customer customer = mapCustomerFromDatabase(resultSet);
        customerArrayList.add(customer);

        while(resultSet.next()) {
            customer = mapCustomerFromDatabase(resultSet);
            customerArrayList.add(customer);
        }

        return customerArrayList.toArray(new Customer[0]);
    }
    private static Customer mapCustomerFromDatabase(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();

        customer.setGender(resultSet.getNString(2));

        customer.setTitle(resultSet.getNString(3));

        customer.setName(resultSet.getNString(4));

        customer.setFamilyName(resultSet.getNString(5));

        customer.setBirthday(LocalDate.parse(Util.formateDate(resultSet)));

        customer.setStreet(resultSet.getNString(7));

        customer.setHouseNumber(resultSet.getNString(8));

        customer.setPostcode(resultSet.getNString(9));

        customer.setCity(resultSet.getString(10));

        customer.setTelefon(resultSet.getNString(11));

        customer.setMobil(resultSet.getNString(12));

        customer.setTelefon(resultSet.getNString(13));

        customer.setEmail(resultSet.getNString(14));

        customer.setNewsletter(resultSet.getBoolean(15));

        return customer;
    }

}
