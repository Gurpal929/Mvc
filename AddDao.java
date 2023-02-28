import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class AddDao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;

        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_numbers");
        return con;
    }

}
