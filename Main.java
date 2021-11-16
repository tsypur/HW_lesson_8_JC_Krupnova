import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DbHandler dbHandler = new DbHandler();

        DayTemp dayTemp = new DayTemp();
        dayTemp.date = "17.11";
        dayTemp.maxTemp = "5";
        dayTemp.minTemp = "-10";


        dbHandler.addDayTemp(dayTemp);
        System.out.println(dbHandler.findAllDayTemp());


    }
}
