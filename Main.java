import controller.Controller;
import database.Database;
import service.CustomerOperations;

import java.sql.SQLException;

public class Main {
      public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database mydb = new Database();
        Controller myc = new Controller(mydb);
        CustomerOperations customerOperations = new CustomerOperations(mydb);
        myc.determineNextAction();
    }
}
