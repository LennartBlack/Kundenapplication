import controller.Controller;
import database.Database;

import java.sql.SQLException;

public class Main {
    Database database = new Database();
    Controller controller = new Controller(database);



    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database mydb = new Database();
        Controller myc = new Controller(mydb);
        myc.determineNextAction();
    }
}
