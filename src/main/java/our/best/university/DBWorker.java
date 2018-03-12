package our.best.university;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
@Setter
public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/university?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;
    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
