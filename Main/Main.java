package Main;

import Controll.Controller;
import Database.Database;

import java.sql.SQLException;

public class Main {
    Database mydb = new Database();
    Controller myc = new Controller(mydb);

    public Main() throws SQLException, ClassNotFoundException {
    }
}
