import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    public final String PATH_DB = "jdbc:sqlite:C:\\Users\\user\\IdeaProjects\\untitled1\\src\\main\\resources\\DayTemp.db";

    Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection(PATH_DB);
    }

    public void addDayTemp(DayTemp dayTemp) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO DayTemp('data', 'maxTemp', 'minTemp')" +
                        " VALUES(?, ?, ?)"
        )) {
            try {
                statement.setObject(1, dayTemp.date);
                statement.setObject(2, dayTemp.maxTemp);
                statement.setObject(3, dayTemp.minTemp);
                statement.execute();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<DayTemp> findAllDayTemp() throws SQLException {
        List<DayTemp> dayTemps = new ArrayList<>();
        try(Statement dayTemp = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DayTemp");
            while (resultSet.next()) {
                DayTemp student = new DayTemp();
                dayTemp.date = resultSet.getString("date");
                dayTemp.maxTemp = resultSet.getInt("maxTemp");
                dayTemp.minTemp = resultSet.getString("minTemp");
                dayTemps.add(dayTemp);
            }

        } catch (Exception e) {}

        return dayTemps;
    }



}
