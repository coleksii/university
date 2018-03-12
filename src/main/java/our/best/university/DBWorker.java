package our.best.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/university?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
