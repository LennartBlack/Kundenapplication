import Controller.Controller;
import Database.Database;
import View.ConsoleOutput;

import java.sql.SQLException;

public class Main {
    Database mydb = new Database();
    Controller myc = new Controller(mydb);



    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database mydb = new Database();
        Controller myc = new Controller(mydb);
        myc.askWhatToDo();
    }
}
