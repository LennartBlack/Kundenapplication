import controller.Controller;
import view.ConsoleOutput;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        Controller myc = new Controller();
        ConsoleOutput.greetUser();
        myc.determineNextAction();
    }
}
