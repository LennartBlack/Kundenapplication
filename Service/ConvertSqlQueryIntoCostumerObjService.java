package Service;

import Database.Database;
import Modell.Costumer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class ConvertSqlQueryIntoCostumerObjService {
    public ConvertSqlQueryIntoCostumerObjService(Database db) throws SQLException, ClassNotFoundException {

    }
    public static Costumer[] convertResultSetIntoCostumerObj(ResultSet resultSet) throws SQLException {
        ArrayList<Costumer> costumerArrayList = new ArrayList<>();
        while(resultSet.next()) {
            Costumer c = new Costumer();
            // ID
            c.setID(resultSet.getInt(1));
            // Gender
            c.setGender(resultSet.getNString(2));
            // Titel
            c.setTitle(resultSet.getNString(3));
            // Name
            c.setName(resultSet.getNString(4));
            // Family name
            c.setFamilyName(resultSet.getNString(5));
            // Birthday
            c.setBirthday(LocalDate.parse(formateDate(resultSet)));
            // Street
            c.setStreet(resultSet.getNString(7));
            // House number
            c.setHouseNumber(resultSet.getNString(8));
            // Postcode
            c.setPlz(resultSet.getNString(9));
            // City
            c.setCity(resultSet.getString(10));
            // Telephone
            c.setTelefon(resultSet.getNString(11));
            // Mobil
            c.setMobil(resultSet.getNString(12));
            // Telefax
            c.setTelefon(resultSet.getNString(13));
            // E-Mail
            c.setEmail(resultSet.getNString(14));
            // Newsletter
            c.setNewsletter(resultSet.getBoolean(15));
            costumerArrayList.add(c);
        }
        return costumerArrayList.toArray(new Costumer[0]);
    }

    private static String formateDate(ResultSet resultSet) throws SQLException {
        java.sql.Date dateFromDatabase = resultSet.getDate("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateFromDatabase);
    }
}
